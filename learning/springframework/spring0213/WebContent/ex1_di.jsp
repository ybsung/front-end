<%@page import="ex1.Ex1_MessageApp"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ex1_di.jsp</title>
</head>
<body>
<%
// Spring Container�� ����
	ApplicationContext ctx = 
				new GenericXmlApplicationContext("ex1/ex1.xml");

// Ex1_MessageApp�� ���۷����� ȹ�� -> id
	Ex1_MessageApp em1 = ctx.getBean("msg",Ex1_MessageApp.class);

// �� ���
	String message = em1.printMsg();
%><p style="color:blue">
	<%=message %>
</p>
</body>
</html>


