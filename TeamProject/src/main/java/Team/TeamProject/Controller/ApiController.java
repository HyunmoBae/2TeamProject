package Team.TeamProject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ApiController {

    @GetMapping("/api")
    // api 호출 메서드
    public String callApi() throws IOException {
        StringBuilder result = new StringBuilder();

        String urlStr = "http://apis.data.go.kr/B553077/api/open/sdsc2/storeListInArea?" +
                // 인증키
                "&serviceKey=MeKpYik6HKlwmVVBv4gbrrUo%2B51qkAPSIi2ySd5KcGJwMFyx6tOyso6AXxUoA69BCyzh2vF2mYrLNuweuV7pTg%3D%3D" +
                // 현재 요청 페이지 번호
                "&pageNo=1"+
                // 페이지당 건수
                "&numOfRows=100"+
                // 상권번호
                "&key=10351" +
                // 상권업종 소분류코드
                "&indsSclsCd=I21201"+
                // 데이터 타입
                "&type=json";

        URL url  = new URL(urlStr);

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");

        BufferedReader br;

        br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));

        String returnLine;

        while((returnLine = br.readLine()) != null) {
            result.append(returnLine+"\n\r");
        }

        urlConnection.disconnect();



        return result.toString();
    }
}
