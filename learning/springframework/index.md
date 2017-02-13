<< WIP >>

Note for Spring Framework

## 1. DI

## 2. Container

- Servlet container (WAS) -> Servlet -> JSP
- Spring container
  - Client -> (list) ->
    - Server (WAS)
      - web.xml ( Servlet, Filter, ... )
      - HttpServletRequest, HttpServletResponse
      - 1. Servlet - Thread (managed with `Singleton`)
        - Service (req, resp)
          - doGet(), doPost()
      - 2. Controller
        - ListAction : List Action a = new ListAction(), `has` relationship
        - list.jsp -> return (list.jsp)
      - 3. Controller -> (cmd) ->
        - Factory -> Interface a = new Model()
        - What if 2 or more models?

## Environment

### Minimum requirements
http://projects.spring.io/spring-framework/
  - JDK 6+ for Spring Framework 4.x
  - JDK 5+ for Spring Framework 3.x

### Programs
  - 7zip : http://www.7-zip.org/
  - JDK
    - `java -version`
    - `javac`
  - System path
    - CLASSPATH : `.;`
    - JAVA_HOME : `C:\Program Files\Java\jdk1.8.0_25`
    - Path : `%JAVA_HOME%\bin;` 추가
  - Workspace
    - Create `C:\SpringBasic`
    - Create `doc`, `workspace`, and `service` in it
  - Spring
    - Spring Tool Suite : https://spring.io/tools/sts/all
    - Spring Framework : http://projects.spring.io/spring-framework/ 
    - Unzip it into `C:\SpringBasic\service\`
    - Launch `C:\SpringBasic\service\spring-tool-suite-3.8.3.RELEASE-e4.6.2-win32-x86_64\sts-bundle\sts-3.8.3.RELEASE\sts.exe`
      - Select workspace : `C:\SpringBasic\workspace`
  - Tomcat
    - http://apache.tt.co.kr/tomcat/tomcat-9/v9.0.0.M17/bin/apache-tomcat-9.0.0.M17-windows-x64.zip in http://tomcat.apache.org/download-90.cgi`
    - Unzip it into `C:\SpringBasic\service\`
  - Oracle XE

## spring123 project
- New project
  - Over `Servers` > New > Dynamic Web Project
    - Project name : `spring123`
    - `New Runtime...`
      - Apache Tomcat v9.0
      - Next > `Browse...` >
      - C:\SpringBasic\service\apache-tomcat-9.0.0.M17-windows-x64\apache-tomcat-9.0.0.M17
- New index and run server
  - Over `spring123` > other > search `html` > select `HTML file` > index.html 
    - Check `Generate web.xml`
  - Over `index.html`
    - `Run as` > `Run on server` > Manually define a new server > `Apache` > `Tomcat v9.0 Server`> Check `Always use this server` 
- Server setting
  - server.xml in Servers/Tomcat v9.0 Server at localhost-config
    - <Connector connectionTimeout="20000" port="80" URIEncoding="EUC-KR" protocol="HTTP/1.1" redirectPort="8443"/>
    - 
  window > web browser > chrome

- Run server
  - Over `spring123`
  - Run As > Run on Server

- SQL
sqlplus / as sysdba
  - sho user;
  - ed adduser (adduser.sql)
    - create user myora identified by test09 default tablespace users;
    - grant resource,connect, create view to myora;
  - @adduser
  - conn myora/test09

## Maven
- over spring123
  - configurate
    - conver to maven
    
- spring123/pon.xml
    above <build>
    ```
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>4.3.6.RELEASE</version>
        </dependency>
    </dependencies>
    ```
    C:\Users\kosta00\.m2
- oracle xe ojdbc6.jar
  - Copy C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar into C:\SpringBasic\service\apache-tomcat-9.0.0.M17-windows-x64\apache-tomcat-9.0.0.M17\lib
  - refresh
  - Stop and start server
  - Check `ojdbc6.jar` in `Apache Tomcat v9.0` of `Package Explorer`

## Ex1

- Over `spring123/src` > new > Class
  - Package : `ex`
  - Name : `Ex1_MessageApp`
  - Code
```
package ex1;

public class Ex1_MessageApp {
	private String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String pringMsg() {
		StringBuffer sb = new StringBuffer();
		sb.append("당신이 입력한 메시지:").append(msg);
		sb.append("입니다.");
		return sb.toString();
	}
}
```

## JSP

- over `spring123` > `Spring Tools` > `Add Spring Project Nature`
- over `ex1` > new > other > Spring Bean Configuration File : DI with XML 
  > next > ex1 > next > check `beans` and `p` > Finish
- ex1.xml
  - ctrl + space : auto completion, <p + ctrl + space, ex1 + ctrl + space
  - code
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<bean id="msg" class="ex1.Ex1_MessageApp">
		<property name="msg" value="안녕하세요~!"></property>
	</bean>

</beans>
```

- JSP
  - Over `WebContent` > New > Other > JSP > ex1_di.jsp
  - Code
```
<%@page import="ex1.Ex1_MessageApp"%>
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
// Spring Container를 생성
	ApplicationContext ctx = new GenericXmlApplicationContext("ex1/ex1.xml");

// Ex1_MessageApp의 레퍼런스를 획득 -> id로 참조
	Ex1_MessageApp em1 = ctx.getBean("msg", Ex1_MessageApp.class);

// 잘 사용
	String message = em1.pringMsg();
%>
<p style="color:blue">
	<%=message %>
</p>
</body>
</html>
```


## Reference
- Spring framework basic chapter 1 : http://blog.naver.com/madplay/220641077920
