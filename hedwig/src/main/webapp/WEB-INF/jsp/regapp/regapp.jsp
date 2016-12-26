<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page session="false"%>
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
	$('#btnRegApp').click(function() {
		var ip = $('#ip').val();
		var dns = $('#dns').val();
		console.log(ip);
		console.log(dns);
						
		$.ajax({
			type : "post",
			url : "/applications",
			contentType : "application/json;charset=utf8",
			datatype : "json",
			data : JSON.stringify({"application_name" : $('#appname').val(),"ip_address" : $('#ip').val(),"dns_address" : $('#dns').val()}),
			success : function(response) {
				if (response.code == '200') {
					alert("register success")
				} else {
					alert("Error code" + response.code+ ":" + response.message);
				}
			},
			error : function() {
				alert(data);
			}
		});

	});
});
</script>

<style>
body {
	padding-top: 100px;
}
</style>

<head>
<title>Register Application</title>
</head>
<body>
	<div class="row">
		<div class="col-md-2 col-md-offset-5">
			<h2 class="text-center">Register Application</h2>
			<div class="form-group">
				<label for="email">어플리케이션 이름</label> <input type="text"
					class="form-control" id="appname" name="appname"
					placeholder="어플리케이션 이름" required>
			</div>
			<div class="form-group">
				<label for="passwd">IP 주소</label> <input type="text"
					class="form-control" id="ip" name="ip" placeholder="IP 주소" required>
			</div>
			<div class="form-group">
				<label for="passwdck">DNS 주소</label> <input type="text"
					class="form-control" id="dns" name="dns" placeholder="DNS 주소"
					required>
			</div>
			<p align="center">
				<button id="btnRegApp" class="btn btn-primary">등록</button>
				<!-- 어플리케이션 등록 취소시 로그인화면으로 가도록 해놓음. 수정 필요 -->
				<a href="/view/login" class="btn btn-default" role="button">취소</a>
			</p>
		</div>
		<div id="msg" class="col-md-4 col-md-offset-4"></div>
	</div>
</body>
</html>