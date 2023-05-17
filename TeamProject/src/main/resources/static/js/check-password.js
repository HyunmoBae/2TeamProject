$("#checkPwBotton").click(function() {
    $.ajax({
        type: "post",
        url:"/profile/checkPw",
        data: {"password": $("#password").val()},
        dataType: "json",
        success: function(response) {
            console.log(data);
            $('form :input').val('');
            window.location.href = "/profile/change-password";
        },
        error: function(xhr, textStatus, errorThrown) {
            console.log("에러발생", errorThrown);
            alert(xhr.responseText);
        }
    });
});