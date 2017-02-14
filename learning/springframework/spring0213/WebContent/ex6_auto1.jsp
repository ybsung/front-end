<%@page import="ex6.Ex6_AutoWired1"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ex6_auto1.jsp</title>
</head>
<body>
<%
	ApplicationContext ctx =
			new GenericXmlApplicationContext("ex6/ex6_auto1.xml");
	Ex6_AutoWired1 ea = ctx.getBean("autoBean1", Ex6_AutoWired1.class);
%>이름 :<%=ea.printName() %>
</body>
</html>







