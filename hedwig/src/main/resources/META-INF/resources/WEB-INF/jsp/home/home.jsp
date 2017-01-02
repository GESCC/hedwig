<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page session="false"%>
<!-- @author : heedong111 -->

<html>
<!-- jQuery -->
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
	$("#btnLogin").click(function() {
		$.ajax({
			type: "POST",
			url: "/users/login",
			contentType : "application/json;charset=utf8",
			datatype : "json",
			data: JSON.stringify({
				email: $("#email").val(),
				password: $("#passwd").val() }),
			success: function(response) {
				if(response.code=='200') {
					location.reload();
				}
				else {
					alert("ERRORCODE" + response.code + " : " + response.message);
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
				<div class="form-group">
					<label for="email">이메일 주소</label> <input type="email"
						class="form-control" id="email" name="email"
						placeholder="이메일을 입력하세요" required>
				</div>
				<div class="form-group">
					<label for="passwd">암호</label> <input type="password"
						class="form-control" id="passwd" name="passwd" placeholder="암호">
				</div>
				<p align="center">
					<button type="submit" id="btnLogin" class="btn btn-default">로그인</button>
				</p>
		</div>
	</div>
</body>
</html>
