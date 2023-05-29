$(document).ready(function () {
    var board_idx = $("#board_idx").text();
    $.ajax({
        type: 'GET',
        url: '/board/detail/count',
        data: {board_idx : board_idx},
        success: function (response) {
            $("#count").text(response);
        },
        error: function (xhr, status, error) {
            console.error(xhr.responseText);
        }
    });

    $("#btndelete").click(function() {

        var confirmDelete = confirm("정말 삭제하시겠습니까?");
        if (confirmDelete) {
            // 삭제 요청을 서버로 보내는 코드 작성
            // $.ajax 또는 $.post 등을 사용하여 서버로 요청을 보낼 수 있습니다.
            $.ajax({
                type: "GET",
                url: "/board/delete",
                data: {board_idx: board_idx},
                success: function (response) {
                    console.log(response);
                    alert(response);
                    window.location.href = '/board/list';
                },
                error: function (xhr, status, error) {
                    console.error(xhr.responseText);
                }
            });
        }
    });
});