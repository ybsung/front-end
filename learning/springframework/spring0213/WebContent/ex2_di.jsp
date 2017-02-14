<%@page import="ex2.Ex2_Message"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ex2_di</title>
</head>
<body>
<%
	ApplicationContext ctx =
				new GenericXmlApplicationContext("ex2/ex2_di.xml");

	Ex2_Message msg = ctx.getBean("msg", Ex2_Message.class);
	
%><p style="background: yellow"><%=msg.msgPrint() %></p>
</body>
</html>





