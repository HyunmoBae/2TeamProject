let passwordCheck = true;

$("#newPassword").keyup(function() {
    var pwd = $(this).val();
    var rePwd = $("#repeatPassword").val();
    // 비밀번호 같은지 확인
    if (rePwd == "") {
        $("#repeatPassword").attr("class", "form-control");
        $("#password_fail").hide();
        $("#password_success").hide();
        passwordCheck = true;
    }
    else if (rePwd == pwd) {//비밀번호 같다면
        $("#repeatPassword").attr("class", "form-control is-valid");
        $("#password_success").show();
        $("#password_fail").hide();
        passwordCheck = false;
    }
    else if (rePwd != pwd){//비밀번호 다르다면
        $("#repeatPassword").attr("class", "form-control is-invalid");
        $("#password_success").hide();
        $("#password_fail").show();
        passwordCheck = true;
    }
});

$("#repeatPassword").keyup(function() {
    var rePwd = $(this).val();
    var pwd = $("#newPassword").val();
    // 비밀번호 같은지 확인
    if (rePwd == "") {
        $("#repeatPassword").attr("class", "form-control");
        $("#password_fail").hide();
        $("#password_success").hide();
        passwordCheck = true;
    }
    else if (rePwd == pwd) {//비밀번호 같다면
        $("#repeatPassword").attr("class", "form-control is-valid");
        $("#password_success").show();
        $("#password_fail").hide();
        passwordCheck = false;
    }
    else if (rePwd != pwd){//비밀번호 다르다면
        $("#repeatPassword").attr("class", "form-control is-invalid");
        $("#password_success").hide();
        $("#password_fail").show();
        passwordCheck = true;
    }
});

$(document).ready(function() {
  // 폼 제출 이벤트 처리
  $("form").submit(function(event) {
    event.preventDefault(); // 폼 기본 제출 동작 방지

    // 입력값 가져오기
    let nowPassword = $("#nowPassword").val();
    let newPassword = $("#newPassword").val();
    let repeatPassword = $("#repeatPassword").val();

    if (nowPassword === '') {
        alert("현재 비밀번호를 입력하세요.");
        return;
    }
    if (newPassword === '') {
        alert("새 비밀번호를 입력하세요.");
        return;
    }
    if(passwordCheck) {
        alert("새 비밀번호 확인을 다시해주세요.");
        return;
    }
    // 서버로 비밀번호 변경 요청 보내기
    $.ajax({
      type: "POST",
      url: "/profile/changePassword",
      data: {
        nowPassword: nowPassword,
        newPassword: newPassword
      },
      success: function(response) {
        // 비밀번호 변경 성공 시 처리
        window.location.href = "/sign/logout";
        alert("비밀번호 변경에 성공했습니다. 다시 로그인 해주세요.");
        $('form :input').val('');
      },
      error: function(xhr, textStatus, errorThrown) {
        // 비밀번호 변경 실패 시 처리
        console.log("에러발생", errorThrown);
        $('form :input').val('');
        alert(xhr.responseText);
      }
    });
  });
});