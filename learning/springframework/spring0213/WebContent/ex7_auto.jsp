<%@page import="ex6.Ex7_Resource"%>
<%@page import="ex6.Ex6_AutoWired"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ex7_auto.jsp</title>
</head>
<body>
<%
	ApplicationContext ctx = 
			new GenericXmlApplicationContext("ex6/ex7_res.xml");
	Ex7_Resource ea = ctx.getBean("resv", Ex7_Resource.class);
%><p><%=ea.printMsg() %></p>
</body>
</html>



