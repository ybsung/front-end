<%@page import="ex2.Exam_DI"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	ApplicationContext ctx = new GenericXmlApplicationContext("ex2/exam2_di.xml");
	Exam_DI ed = ctx.getBean("edi", Exam_DI.class);
%>Today : <%=ed.printDate() %>
</body>
</html>