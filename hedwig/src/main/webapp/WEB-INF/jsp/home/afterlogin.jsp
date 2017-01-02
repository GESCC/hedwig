<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page session="false"%>
<!-- @author : heedong111 -->
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
				<H2> <%= request.getSession().getAttribute("email") %> </H2>
				<a href="/users/logout" class="btn btn-primary" role="button">로그아웃</a>
		</div>
	</div>
</body>
</html>
