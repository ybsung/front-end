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
// Spring Container를 생성
	ApplicationContext ctx = 
				new GenericXmlApplicationContext("ex1/ex1.xml");

// Ex1_MessageApp의 레퍼런스를 획득 -> id
	Ex1_MessageApp em1 = ctx.getBean("msg",Ex1_MessageApp.class);

// 잘 사용
	String message = em1.printMsg();
%><p style="color:blue">
	<%=message %>
</p>
</body>
</html>


