<%@page import="ex5.OrderSystem"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
	String menu = request.getParameter("orderName");
	String path = "ex5/ex5_menu.xml";
	ApplicationContext ctx = 
			new GenericXmlApplicationContext(path);
	OrderSystem os = ctx.getBean(menu, OrderSystem.class);
	String orderName = "";
	if(menu.equals("kor")){
		orderName="한식";
	}else{
		orderName="인도식";
	}
	String res = os.printMenu(orderName);
%><%=res %>




