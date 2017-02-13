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
### exam todate

```
package ex1;

public class Exam_Todate {
private String todate, name;
```

### ex 2

- Over `spring123/src` > new > Class > ex2 Ex2_Resource 
  - Code
```
package ex2;

public class Ex2_Resource {
	private String name;
	// alt + shift + s : short key to generate setter/getter

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
```
- Over `spring123/src` > new > Class > ex2 Ex2_Message
  - Code
```
package ex2;

// 값을 추가 시킬 수 있는 방법은 기본 2가지 setter, 생성자
public class Ex2_Message {
	private Ex2_Resource resource;

	// alt + shift + s > constructor using Fields
	public Ex2_Message(Ex2_Resource resource) {
		super();
		this.resource = resource;
	}

	public void setResource(Ex2_Resource resource) {
		this.resource = resource;
	}
	public String msgPrint() {
		String name = resource.getName();
		return name + "님 안녕하세요!";
	}
}
```
- ex2_di.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="res" class="ex2.Ex2_Resource" p:name="김길동" />
	<!-_ di 시킬 대상을 적용해서 주입시킬 때 ref= 속성을 사용한다ㅣ. -->
	<bean id="msg" class="ex2.Ex2_Message">
		<constructor-arg ref="res" />
		<property name="resource" ref="res" />
	</bean>
</beans>

```
- ex2_di.jsp
```
<%@page import="ex2.Ex2_Message"%>
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
	ApplicationContext ctx = new GenericXmlApplicationContext("ex2/ex2_di.xml");

// Ex1_MessageApp의 레퍼런스를 획득 -> id로 참조
	Ex2_Message msg = ctx.getBean("msg", Ex2_Message.class);

// 잘 사용
	String message = msg.msgPrint();
%>
<p style="background: yellow">
	<%=message %>
</p>
</body>
</html>
```

## Exam DI

- Exam_DI.java
```
package ex2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam_DI {
	private SimpleDateFormat sdf;
	private Date date;
	public String printDate() {
		String todate = sdf.format(date);
		return todate;
	}
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
```



exam_di.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<bean id="sdf" class="java.text.SimpleDateFormat">
		<constructor-arg>
			<value>yyyy-MM-dd</value>
		</constructor-arg>
	</bean>
	<bean id="date" class="java.util.Date"/>
	<bean id="edi" class="ex2.Exam_DI" p:sdf-ref="sdf" p:date-ref="date" />
</beans>
```

## Ex3

Ex3_ServiceImple.java
```
package ex3;

public class Ex3_ServiceImple implements Ex3_Service{
	private int num;
	private String name, str;
	// 생성자로 주입을 받을 때는 기본적으로 String 이 기본값
	public Ex3_ServiceImple(int num) {
		this.num = num;
		System.out.println("Int 호출");
	}
	public Ex3_ServiceImple(String str) {
		this.str = str;
		System.out.println("String 호출");
	}
	public Ex3_ServiceImple(int num, String name) {
		this.num = num;
		this.name = name;
	}
	@Override
	public String print() {
		StringBuffer s  = new StringBuffer();
		int res = num * 10;
		s.append("RES :").append(res);
		return s.toString();
	}
	@Override
	public String call() {
		StringBuffer s  = new StringBuffer();
		s.append(str).append("★");
		return s.toString();
	}
	@Override
	public String moniter() {
		StringBuffer s  = new StringBuffer();
		int res = num + 10;
		s.append("RES :").append(res);
		s.append("Name:").append(name);
		return s.toString();
	}
	

}

```

Ex3_Service.java
```
package ex3;

public interface Ex3_Service {
	public String print();
	public String call();
	public String moniter();
}
```

ex3_const.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="cont1" class="ex3.Ex3_ServiceImple">
		<constructor-arg value="10000" type="int" />
	</bean>
</beans>
```

ex3_const.jsp
```
<%@page import="ex3.Ex3_Service"%>
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
	ApplicationContext ctx = new GenericXmlApplicationContext("ex3/ex3_const.xml");
	Ex3_Service es = ctx.getBean("cont1", Ex3_Service.class);
%>
Str : <%=es.call()%> / Num : <%=es.print() %>
</body>
</html>
```

## Ex5

OrderSystem.java
AS-IS
```
package ex5;

public class OrderSystem {
 
 private KorOrder m1;
 private IndoOrder m2;
 public MenuInter getMenu() {
  return menu;
 }

 public String printMenu(String orderName){
  return m1.order(orderName);
 }
 
}
```
TO-BE
```
package ex5;

public class OrderSystem {
 private MenuInter menu;
 // private KorOrder m1;
 // private IndoOrder m2;
 public MenuInter getMenu() {
  return menu;
 }
 
 public void setMenu(MenuInter menu) {
	this.menu = menu;
}

public String printMenu(String orderName){
  return menu.order(orderName);
 }
}
```

KorOrder.java
```
package ex5;

public class KorOrder implements MenuInter{

	@Override
	public String order(String orderName) {
		StringBuffer sb = new StringBuffer();
		sb.append("오늘의 메인 코스인 한식을 주문하셨군요 ^^");
		sb.append(orderName).append("/ 100000 won");
		return sb.toString();
	}

}
```

IndoOrder.java
```
package ex5;

public class IndoOrder implements MenuInter{

	@Override
	public String order(String orderName) {
		StringBuffer sb = new StringBuffer();
		sb.append("오늘은  인도 요리를 주문하셨군요 ^^");
		sb.append(orderName).append("/ 200000 won");
		return sb.toString();
	}

}
```

MenuInter.java
```
package ex5;

public interface MenuInter {
	public String order(String orderName);
}
```

orderForm.jsp
```
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
```

orderProcess.jsp
```
<%@page import="ex5.OrderSystem"%>
<%@page import="org.springframework.context.support.GenericXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
	String menu = request.getParameter("orderName");
	String path = "ex5/ex5_menu.xml";
	ApplicationContext ctx = new GenericXmlApplicationContext(path);
	OrderSystem os = ctx.getBean(menu, OrderSystem.class);
	String orderName = "";
	if (menu.equals("kor")) {
		orderName="한식";
	} else {
		orderName="인도식";
	}
%><%=res %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
```

ex5_menu.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="menu1" class="ex5.KorOrder" />
	<bean id="menu2" class="ex5.IndoOrder" />
	<bean id="kor" class="ex5.OrderSystem">
		<property name="menu" ref="menu1" />
	</bean>
	<bean id="indo" class="ex5.OrderSystem">
		<property name="menu" ref="menu2" />
	</bean>

</beans>
```

## Ex 6 : Ex6_AutoWired1

Ex6_AutoWired1.java
```
package ex6;

public class Ex6_AutoWired1 {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String printName() {
		return "당신의 이름은" + name + "입니다.";
	}
}
```

ex6_auto1.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="name" class="java.lang.String">
		<constructor-arg>
			<value>김길동</value>
		</constructor-arg>
	</bean>
	<bean id="autoBean1" class="ex6.Ex6_AutoWired1">
		<property name="name" ref="name" />
	</bean>
</beans>
```

ex6_auto1.jsp
```
<%@page import="ex6.Ex6_AutoWired1"%>
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
	ApplicationContext ctx = new GenericXmlApplicationContext("ex6/ex6_auto1.xml");
	Ex6_AutoWired1 ea = ctx.getBean("autoBean1", Ex6_AutoWired1.class);
%>
이름 : <%=ea.printName() %>
</body>
</html>
```

Over `ex6_auto1.jsp` > Run as > Run on Server 

## Reference
- Spring framework basic chapter 1 : http://blog.naver.com/madplay/220641077920
