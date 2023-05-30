$(document).ready(function () {
  var board_idx = $("#board_idx").text();
  $.ajax({
    type: "GET",
    url: "/board/detail/count",
    data: { board_idx: board_idx },
    success: function (response) {
      $("#count").text(response);
    },
    error: function (xhr, status, error) {
      console.error(xhr.responseText);
    },
  });

  $("#btndelete").click(function () {
    var confirmDelete = confirm("정말 삭제하시겠습니까?");
    if (confirmDelete) {
      // 삭제 요청을 서버로 보내는 코드 작성
      // $.ajax 또는 $.post 등을 사용하여 서버로 요청을 보낼 수 있습니다.
      $.ajax({
        type: "GET",
        url: "/board/delete",
        data: { board_idx: board_idx },
        success: function (response) {
          console.log(response);
          alert(response);
          window.location.href = "/board/list";
        },
        error: function (xhr, status, error) {
          console.error(xhr.responseText);
        },
      });
    }
  });

  $("#saveBtn").click(function () {
    var review = $("textarea.form-control").val(); // 입력된 댓글 내용
    console.log(review);
    // 입력된 댓글이 비어있는지 확인
    if (review.trim() === "") {
      alert("댓글을 입력하세요.");
      return;
    }
    // Ajax 요청을 보내고 댓글을 서버에 저장
    $.ajax({
      url: "/board/review", // 댓글을 저장할 엔드포인트 URL
      type: "POST",
      data: { 
        review: review, 
        board_idx : board_idx
      }, // 서버에 전송할 데이터
      success: function (reviewDto) {
        console.log(reviewDto);
        // var comment = reviewDto.comment; // 저장된 댓글 데이터

        // // 댓글 아이템 요소 생성
        // var commentItem = $(
        //   '<li class="list-group-item d-flex justify-content-between"></li>'
        // );

        // // 댓글 내용 추가
        // var contentDiv = $("<div></div>").text(comment.content);
        // commentItem.append(contentDiv);

        // // 작성자 정보 추가
        // var authorDiv = $('<div class="me-2"></div>').text(comment.author);
        // commentItem.append(authorDiv);

        // // 수정 버튼 추가
        // var editButton = $(
        //   '<button class="btn btn-primary btn-sm me-2">수정</button>'
        // );
        // commentItem.append(editButton);

        // // 삭제 버튼 추가
        // var deleteButton = $(
        //   '<button class="btn btn-danger btn-sm">삭제</button>'
        // );
        // commentItem.append(deleteButton);

        // // 새로 작성된 댓글 아이템을 댓글 리스트에 추가
        // $("#contents").prepend(commentItem);

        // // 댓글 작성 후 입력 필드 초기화
        // $("textarea.form-control").val("");
      },
      error: function (xhr) {
        console.error(xhr.responseText);
      },
    });
  });
});
