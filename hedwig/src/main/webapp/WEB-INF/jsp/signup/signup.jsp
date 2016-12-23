<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page session="false"%>
<html>
<script src="http://code.jquery.com/jquery-1.12.0.js"></script>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function() {
      $('#btnLogin').click(function() {
    	var passck1 = $('#passwd').val();
    	var passck2 = $('#passwdck').val();
    	console.log(passck1);
    	if(passck1 != passck2){
    		alert("입력하신 두 비밀번호가 일치하지 않습니다.");
    		return false;
    	}
    	else {
        var action = $('signup').attr("action");
        var form_data = { "email": $('#email').val(), "password": $('#passwd').val(), "phone_number" :$('#phone').val() };
        $.ajax({
                  type: "POST",
                  url: action,
                  data: form_data,
                  success: function(data) {
                	  if(data.code == "500"){
                		  $('#msg').html("<h2>Successfully Signed Up!");
                		  setTimeout($(location).attr('href', '/'),3000);
                	  }
                	  else{
                		  $('#msg').html(data.message);
                	  }
                  },
                  error: function() {
                    $('#msg').html("<h2>Error</h2>");
                  }
        	})
        }
      });
    });
  </script>
<style>
body {
	padding-top: 100px;
}
</style>

<head>
<title>SignUp</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2 col-md-offset-5">
			<h2 class="text-center">Sign Up</h2>
			<form id="signup" name="signup" action="/users" method="post">
				<div class="form-group">
					<label for="email">이메일 주소</label> <input type="email"
						class="form-control" id="email" name="email"
						placeholder="이메일을 입력하세요" required>
				</div>
				<div class="form-group">
					<label for="passwd">패스워드</label> <input type="password"
						class="form-control" id="passwd" name="passwd" placeholder="패스워드"
						required>
				</div>
				<div class="form-group">
					<label for="passwdck">패스워드 확인</label> <input type="password"
						class="form-control" id="passwdck" name="passwdck"
						placeholder="패스워드 확인" required>
				</div>
				<div class="form-group">
					<label for="phone">전화번호</label> <input type="tel"
						class="form-control" id="phone" name="phone" placeholder="전화번호"
						required>
				</div>
				<p align="center">
					<button type="submit" id="btnLogin" class="btn btn-default">Sign
						Up</button>
				</p>
			</form>
		</div>
		<div id="msg" class="col-md-4 col-md-offset-4"></div>
	</div>
</body>
</html>
