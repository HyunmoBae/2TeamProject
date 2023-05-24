$(document).ready(function () {
    $('#summernote').summernote({
        height: 600,                 // 에디터 높이
        minHeight: null,             // 최소 높이
        maxHeight: null,             // 최대 높이
        focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
        lang: "ko-KR",					// 한글 설정
        placeholder: '내용을 입력하세요.',	//placeholder 설정
        toolbar: [
            ['fontsize', ['fontsize']],
            ['style', ['bold', 'italic', 'underline', 'strikethrough', 'clear']],
            ['color', ['forecolor', 'color']],
            ['table', ['table']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['insert', ['picture', 'link']],
            ['view', ['fullscreen', 'help']]
        ],
        callbacks: {
            onImageUpload: function (files) {
                // 파일 업로드(다중업로드를 위해 반복문 사용)
                for (var i = files.length - 1; i >= 0; i--) {
                    uploadSummernoteImageFiles([files[i]], this);
                }
            }
        }
    });
    function uploadSummernoteImageFiles(files, editor) {
        var formData = new FormData();
        for (var i = 0; i < files.length; i++) {
            formData.append("files", files[i]);
        }

        $.ajax({
            data: formData,
            type: "POST",
            url: "/board/uploadSummernoteImageFiles",
            contentType: false,
            processData: false,
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    var imageUrl = data[i];
                    $(editor).summernote('insertImage', imageUrl);
                }
            },
            error: function (xhr, status, error) {
                console.error('이미지 업로드 실패');
                console.error(error);
            }
        });
    }

    $('#btnSave').click(function () {
        var title = $('#title').val();
        var contents = $('#summernote').summernote('code');
        var category = $('#category').val();

        // BoardDto 생성
        var boardDto = {
            title: title,
            contents: contents,
            category: category,
            count: 0,
            imageDtos: []  // 이미지는 이미지 업로드 시 자동으로 삽입되므로 따로 지정하지 않음
        };

        // Ajax를 이용하여 게시글 저장 요청
        $.ajax({
            type: 'POST',
            url: '/board/saveBoard/',
            contentType: 'application/json',
            data: JSON.stringify(boardDto),
            success: function (response) {
                // 저장 성공 시 처리
                console.log('게시글 저장 성공');
                // 게시글 저장 후 어떤 페이지로 이동할지 처리
            },
            error: function (xhr, status, error) {
                console.error('게시글 저장 실패');
                console.error(xhr.responseText);
            }
        });
    });

    $('#btnList').click(function () {
        // 목록으로 이동하는 처리
        // ...
    });
});