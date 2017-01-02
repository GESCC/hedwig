<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page session="false"%>
<!-- @author:ChickenPaellas -->
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
	
<style>
th,td {
	text-align: center;
}
</style>

<head>
<title>Administrator</title>
</head>
<body>
<h1 class="text-center">Administrator Page</h1><br>
<table id="messageList" class="table table-striped table-hover table-bordered">
	<tr>
		<th class="col-md-1">No</th>
		<th class="col-md-1">제목</th>
		<th class="col-md-3">내용</th>
		<th class="col-md-1">결과</th>
		<th class="col-md-2">서비스</th>
		<th class="col-md-2">발신번호</th>
		<th class="col-md-2">수신날짜</th>
	</tr>
</table>

<div class="row">
	<p align="center">
	<a href="/view/regapp" class="btn btn-primary" role="button">어플리케이션 등록</a>
	<a href="/users/logout" class="btn btn-default" role="button">로그아웃</a>
	</p>
</div>

<script>
	var num=1;
	$(document).ready(function(){
		$.ajax({
			url : "/admin/messages",
			dataType : "json",
			success : function(data) {
				$.each(data, function(index, entry) {
					$('#messageList').append("<tr><td>" + num++ + "</td><td>" + entry.title + "</td><td>" + entry.contents + "</td><td>" + entry.result + "</td><td>"
							 + entry.send_application_name + "</td><td>" + entry.receiver_number + "</td><td>" + entry.send_date + "</td></tr>");
					
				});
			}
		});
	});	
	
</script>
</body>
</html>