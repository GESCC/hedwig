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
			<form action="#" method="post">
				<div class="form-group">
					<label for="email">이메일 주소</label> <input type="email"
						class="form-control" id="email" name="email"
						placeholder="이메일을 입력하세요" required="이메일을 입력해주세요.">
				</div>
				<div class="form-group">
					<label for="passwd">암호</label> <input type="password"
						class="form-control" id="passwd" name="passwd" placeholder="암호" require="패스워드를 입력해주세요">
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" name="rememberme">Remember
						Me
					</label>
				</div>
				<p align="center">
					<button type="submit" class="btn btn-default">제출</button>
					<a href="signup.jsp" class="btn btn-primary" role="button">회원가입</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>
