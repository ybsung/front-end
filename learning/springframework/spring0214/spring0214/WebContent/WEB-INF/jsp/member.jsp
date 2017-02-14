<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>member.jsp</title>
</head>
<body>
	<div><h1>회원가입 예제 폼</h1>
		<form action="addmember" method="post">
			<p> id : <input type="text" name="id" id="id"> </p>
			<p> pwd : <input type="password" name="password" id="password"> </p>
			<p> name : <input type="text" name="name" id="name"> </p>
			<p> address : <input type="text" name="address" id="address"> </p>
			<p><input type="submit" value="addMember"></p>
		</form>
	</div>
</body>
</html>


