package Team.TeamProject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ImageService {
    private static final String UPLOAD_PATH = "C:/summernote_image/"; // 이미지 업로드 경로 설정

    /**
     * 이미지 업로드
     */
    public String uploadFile(String originalFileName, byte[] fileData) throws Exception {
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); // 파일 확장자
        String savedFileName = UUID.randomUUID().toString() + extension; // 저장할 파일명

        String fileUploadPath = UPLOAD_PATH + "/" + savedFileName; // 파일 저장 경로

        try (OutputStream outputStream = new FileOutputStream(fileUploadPath)) {
            outputStream.write(fileData); // 파일 저장
        }

        return savedFileName;
    }

    /**
     * 이미지 삭제
     */
    public void deleteFile(String fileName) throws Exception {
        String filePath = UPLOAD_PATH + "/" + fileName;
        File deleteFile = new File(filePath);
        if (deleteFile.exists()) {
            deleteFile.delete();
            log.info("파일을 삭제하였습니다.");
        } else {
            log.info("파일이 존재하지 않습니다.");
        }
    }

    /**
     * 각 파일 처리 하는 로직
     */
    public byte[] getFileDataFromUrl(String imageUrl) throws Exception {
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("GET");

        try (InputStream inputStream = connection.getInputStream()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }
}
