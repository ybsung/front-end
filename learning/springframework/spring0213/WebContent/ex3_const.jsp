<%@page import="ex3.Ex3_Service"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ex3_const.jsp</title>
</head>
<body>
<%
	ApplicationContext ctx = 
			new GenericXmlApplicationContext("ex3/ex3_const.xml");
	Ex3_Service  es = ctx.getBean("cont1", Ex3_Service.class);
%>Str : <%=es.call()%>/ Num : <%=es.print() %> <br />
<!-- cont2로 요청하면 Ex3_ServiceImple(int num, String name) 를 호출 하도록
	bean을 정의하세요.
 -->
 <%
 Ex3_Service  es2 = ctx.getBean("cont2", Ex3_Service.class);
 %><%=es2.moniter() %>
</body>
</html>





