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
      $('#btnSignup').click(function() {
    	var passck1 = $('#passwd').val();
    	var passck2 = $('#passwdck').val();
    	console.log(passck1);
    	if(passck1 != passck2){
    		alert("입력하신 두 비밀번호가 일치하지 않습니다.");
    		return false;
    	}
    	else {
        $.ajax({
                  type: "post",
                  url: "/users",
                  contentType : "application/json;charset=utf8",
                  datatype : "json",
                  data: JSON.stringify({"email": $('#email').val(), "password": $('#passwd').val(), "phone_number" :$('#phone').val()}),
                  success: function(response) {
                	  if(response.code == '200') {
      					alert("success");
      				}
      					else {
      					alert(response.code);
      				}
                  },
                  error: function() {
                    alert(data);
                  }
        	});
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
					<button id="btnSignup" class="btn btn-default">Sign Up</button>
				</p>
		</div>
		<div id="msg" class="col-md-4 col-md-offset-4"></div>
	</div>
</body>
</html>
