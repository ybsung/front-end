<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>orderForm.jsp</title>
</head>
<body>
	<div id="wrap">
		<form method="post" action="orderProcess.jsp">
			<select name="orderName">
				<option value="kor">한식</option>
				<option value="indo">인도식</option>
			</select>
			<input type="submit" value="send">
		</form>
	</div>
</body>
</html>