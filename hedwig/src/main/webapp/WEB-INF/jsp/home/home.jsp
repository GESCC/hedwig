<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page session="false"%>
<html>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- jQuery -->
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script>
$(document).ready(function() {
	$("#btnLogin").click(function() {
		var action = $("#login").attr('action');
		var form_data = {
			email: $("#email").val(),
			password: $("password").val(),
		};
		$.ajax({
			type: "POST",
			url: action,
			data: form_data,
			success: function(response) {
				if(response == 'success') {
					$("#message").html("<p style='color:green;font-weight:bold'>로그인 성공!</p>");
					$("#form1").slideUp('slow');
				}
				else {
					$("#message").html("<p style='color:red'>아이디 또는 비밀번호가 잘못되었습니다.</p>");	
				}
			}
		});
		return false;
	});
});
</script>
<style>
body {
	padding-top: 100px;
}
</style>
<head>
<title>login</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2 col-md-offset-5">
			<h2 class="text-center">LOGIN</h2>
			<form id="login" method="post" action="/users/login">
				<div class="form-group">
					<label for="email">이메일 주소</label> <input type="email"
						class="form-control" id="email" name="email"
						placeholder="이메일을 입력하세요" required>
				</div>
				<div class="form-group">
					<label for="passwd">암호</label> <input type="password"
						class="form-control" id="passwd" name="passwd" placeholder="암호">
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" name="rememberme">Remember
						Me
					</label>
				</div>
				<p align="center">
					<button type="submit" id="btnLogin" class="btn btn-default">제출</button>
					<a href="/view/signup" class="btn btn-primary" role="button">회원가입</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>
