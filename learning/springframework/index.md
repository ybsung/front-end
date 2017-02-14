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

### New project

- New project
  - Over `Servers` > `New` > `Dynamic Web Project`
    - Project name : `spring123`
    - `New Runtime...`
      - `Apache` > Select `Apache Tomcat v9.0` > `Next`
      - `Browse...`
      	- Select `C:\SpringBasic\service\apache-tomcat-9.0.0.M17-windows-x64\apache-tomcat-9.0.0.M17`
        - `Finish`
      - `Finish`
    - 'Next'
  - `Next`
  - Check `Generate web.xml deployment descriptor`

- New index and run server
  - Over `spring123` > `Other...` > 
    - Search `html` > Select `HTML file` > `Next`
    - index.html > 'Finish'
  - Over `index.html`
    - `Run as` > `Run on Server`
    - Choose `Manually define a new server` > `Apache` > `Tomcat v9.0 Server`> Check `Always use this server`
    - `Finish`

### To Maven

- Over `spring123` > `Configure` > `Convert to Maven Project` > `Finish`

### Add Spring Project Nature

- Over `spring123` > `Spring Tools` > `Add Spring Project Nature`

### pom.xml in `spring123`

- Select `pom.xml` file
- Select `pom.xml` tab
- Add the following code above `<build>`

```
<dependencies>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>4.3.6.RELEASE</version>
</dependency>
</dependencies>
```
If there is any dependency errors, please remove the folder in `C:\Users\username\.m2`.
    
### oracle xe ojdbc6.jar

  - Copy `C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar` into `C:\SpringBasic\service\apache-tomcat-9.0.0.M17-windows-x64\apache-tomcat-9.0.0.M17\lib`
  - Over `sping123` > `Refresh`
  - Stop and start server
  - Check if `ojdbc6.jar` in `Java Resources` / `Libraries` / `Apache Tomcat v9.0` of `Package Explorer` exists

### index.html

```
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
Test
</body>
</html>
```

Output
```
Test
```

### STS ( Spring Tool Suite ), Server, and SQL settings

#### STS

- Default web browser
  - `Window` > `Web Browser` > `Chrome`

#### Server

- Server setting
  - server.xml in `Servers` / `Tomcat v9.0 Server at localhost-config`
    - Replact the code at line 63 with `<Connector connectionTimeout="20000" port="80" URIEncoding="EUC-KR" protocol="HTTP/1.1" redirectPort="8443"/>`
    
- Run server
  - Over `spring123` > `Run As` > `Run on Server`

#### SQL

sqlplus / as sysdba
  - sho user;
  - ed adduser (adduser.sql)
    - create user myora identified by test09 default tablespace users;
    - grant resource,connect, create view to myora;
  - @adduser
  - conn myora/test09

## Ex1

### Ex1_MessageApp.java

- Over `spring123/src` > `New` > `Class`
  - Package : `ex`
  - Name : `Ex1_MessageApp`

```
package ex1;

public class Ex1_MessageApp {
	private String msg;
	//property ==> setter호출
	//Spring은 외부 조립기 역할, 객체들의 관계를 맞추어 주는 역할...
	//스프링컨테이너는 싱글톤 레지스터리가 있어서 빈으로 등록하는 모든
	//객체를 싱글톤레지스터리에 등록 해놓고 사용한다. 
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String printMsg(){
		StringBuffer sb  = new StringBuffer();
		sb.append("당신이 입력한 메세지:").append(msg);
		sb.append("입니다.");
		return sb.toString();
	}
}
```

###  ex1.xml

- Over `ex1` > `New` > `Other...` > `Spring Bean Configuration File` : DI with XML 
  > `Next` > ex1 > `Next` > Check `beans` and `p` > `Finish`
- TIP > Auto completion
  - ctrl + space : auto completion, <p + ctrl + space, ex1 + ctrl + space

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<!-- 스프링에 의해서 문자열 값을 주입시켜 보자. -->
	<bean id="msg" class="ex1.Ex1_MessageApp">
	<property name="msg" value="안녕하세요~!"/>
	</bean>
</beans>
```

### ex_di.jsp

- Over `WebContent` > New > Other > JSP > File name: `ex1_di.jsp` > `Finish`

```
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
```

### Check output

- Over `ex_di.jsp` > `Run as` > `Run on Server`

```
당신이 입력한 메세지:안녕하세요~!입니다.
```

### Exam_Todate.java

- Over `ex1` > `New` > `Class` > Name : `Exam_Todate` > `Finish`

```
package ex1;

import java.text.SimpleDateFormat;
import java.util.Date;
//  Exam2_DI 로 복사 해서 
// new를 spring으로 위임시켜서 정상적으로 돌아가도록 구현..
public class Exam_Todate {
	private String todate, name;
	public void setName(String name) { // value값을 주입
		this.name = name;
	}
	public Exam_Todate() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		todate = f.format(new Date());
	}
	public String printDate(){
		return todate+"/"+name;
	}
	
}
```

### ex_di.xml

- Over `ex1` > `New` > `Other...` > `Spring Bean Configuration File` 
  > `Next` > File name : `ex_di` > `Next` > Check `beans` and `p` > `Finish`
  
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<!-- scope="prototype" : 이것은 싱글톤을 해제하는 속성 -->
	<bean id="msg" class="ex1.Ex1_MessageApp" scope="prototype">
		<property name="msg" value="안녕하세요!"/>
	</bean>
	<bean id="today" class="ex1.Exam_Todate">
		<property name="name" value="김길동"/>
	</bean>
	
</beans>
```

## Ex 2

### Ex2_Resource.java

- Over `spring123/src` > `New` > `Class` > Package: `ex2`, File name: `Ex2_Resource` 

```
package ex2;

public class Ex2_Resource {
	private String name;
	//alt + shift + s :단축키 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
```

### Ex2_Message.java

- Over `spring123/src` > `New` > `Class` > Package: `ex2`, File name: `Ex2_Message`
  
```
package ex2;
//값을 추가 시킬 수 있는 방법은 기본 2가지 setter, 생성자 
public class Ex2_Message {
	private Ex2_Resource resource;

	public Ex2_Message() {
	}
	public Ex2_Message(Ex2_Resource resource) {
		this.resource = resource;
	}
	public void setResource(Ex2_Resource resource) {
		this.resource = resource;
	}
	public String msgPrint(){
		String name = resource.getName();
		return name+"님 안녕하세요!";
	}
}
```

### ex2_di.xml

- Over `ex2` > `New` > `Other...` > `Spring Bean Configuration File` 
  > `Next` > File name : `ex2_di` > `Next` > Check `beans` and `p` > `Finish`
  
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<bean id="res" class="ex2.Ex2_Resource" p:name="김길동"/>
	<!-- di 시킬 대상을 적용해서 주입시킬때 ref= 속성을 사용한다. -->
	<bean id="msg" class="ex2.Ex2_Message">
	<constructor-arg ref="res"/>
	<property name="resource" ref="res"/>
	</bean>
</beans>
```

### ex2_di.jsp

- Over `WebContent` > New > Other > JSP > File name: ex2_di.jsp > `Finish`

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
<title>ex2_di</title>
</head>
<body>
<%
	ApplicationContext ctx = new GenericXmlApplicationContext("ex2/ex2_di.xml");

	Ex2_Message msg = ctx.getBean("msg", Ex2_Message.class);
	
%><p style="background: yellow"><%=msg.msgPrint() %></p>
</body>
</html>
```

### Check output

- Over `ex2_di.jsp` > `Run as` > `Run on Server`

```
김길동님 안녕하세요!
```

## Exam DI

### Exam_DI.java in `ex2`

- Over `ex2` > `New` > `Class` > Package: `ex2`, File name: `Exam_DI`

```
package ex2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam_DI {
	private SimpleDateFormat sdf;
	private Date date;
	public String printDate(){
		String todate = sdf.format(date);
		return todate;
	}
	//new SimpleDateFormat("yyyy-MM-dd");
	public void setSdf(SimpleDateFormat sdf) {
		this.sdf = sdf;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
```

### exam_di.xml

- Over `ex2` > `New` > `Other...` > `Spring Bean Configuration File` 
  > `Next` > File name : `exam_di` > `Next` > Check `beans` and `p` > `Finish`
  
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
	<bean id="edi" class="ex2.Exam_DI" p:sdf-ref="sdf" 
	p:date-ref="date"/>
</beans>
```

## Ex3

### Ex3_Service.java

- Over `spring123/src` > `New` > `Class` > Package: `ex3`, File name: `Ex3_Service` 

```
package ex3;

public interface Ex3_Service {
	public String print();
	public String call();
	public String moniter();
}
```

###Ex3_ServiceImple.java

- Over `ex3` > `New` > `Class` > Name: `Ex3_ServiceImple`

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

### ex3_const.xml

- Over `ex3` > `New` > `Other...` > `Spring Bean Configuration File` 
  > `Next` > File name : `ex3_const` > `Next` > Check `beans` and `p` > `Finish`
  
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
<!-- ex3_const -->
	<bean id="cont1" class="ex3.Ex3_ServiceImple">
	<constructor-arg value="10000" type="int"/>
	</bean>
	<!-- 
		생성자 오버로딩일 경우 생성자의 자료형을 명시 해줘야 한다.
		cont2라 이름으로 생성자의 인자가 2개인 빈을 만들어서 moniter()를 호출하시오.
	 -->
	 <bean id="cont2" class="ex3.Ex3_ServiceImple">
	 <constructor-arg value="10000"/>
	 <constructor-arg value="김길동"/>
	 </bean>
</beans>
```

### ex3_const.jsp

- Over `WebContent` > New > Other > JSP > File name: ex3_const.jsp > `Finish`

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
```

### Check output

- Over `ex3_const.jsp` > `Run as` > `Run on Server`

```
Str : null★/ Num : RES :100000 
RES :10010Name:김길동
```

## Ex5

### OrderSystem.java

- Over `spring123/src` > `New` > `Class` > Package: `ex5`, File name: `OrderSystem` 

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
	// 다형성으로 설계된 빈 객체!
	private MenuInter menu;
	//private KorOrder m1;
	//private IndoOrder m2;
	////private ChinaOrder m3;
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

### KorOrder.java

- Over `ex5` > `New` > `Class` > Name: `KorOrder` 

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

### IndoOrder.java

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

### ChinaOrder.java

```
package ex5;

public class ChinaOrder {

}
```

### MenuInter.java

```
package ex5;
//Spring DI에서 다형성을 구현하기 위한 인터페이스를 설계
public interface MenuInter {
	// 주문한다.
	public String order(String orderName);
}
```

### ex5_menu.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	<bean id="menu1" class="ex5.KorOrder"/>
	<bean id="menu2" class="ex5.IndoOrder"/>
	<bean id="kor" class="ex5.OrderSystem">
		<property name="menu" ref="menu1"/>
	</bean>
	<bean id="indo" class="ex5.OrderSystem">
		<property name="menu" ref="menu2"/>
	</bean>
</beans>
```

### orderForm.jsp

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

### orderProcess.jsp

```
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
```

## Ex 6 : Ex6_AutoWired1

### Ex6_AutoWired1.java

AS-IS
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

### ex6_auto1.xml

AS-IS

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

### ex6_auto1.jsp

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
```

Over `ex6_auto1.jsp` > Run as > Run on Server 

## Ex6 with context

Add ex6_auto1.xml Namespaces context

### Ex6_AutoWired.java

TO-BE

```
package ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Ex6_AutoWired1 {
	@Autowired
	@Qualifier("h")
	private String name;
	//ByName으로 검색을 함. bean의 아이디나 이름이 검색할 property와 동일한 이름일경우
	//ByType으로 검색을 함. 같은 이름의 빈이 없을 경우, 같은 타입으로 검색
	//	@Autowired
//	public void setName(String name) {
//		this.name = name;
//	}

	public String printName(){
		return "당신의 이름은"+name+"입니다.";
	}
}
```

Finally

```
package ex6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Ex6_AutoWired {
	//byName : property와 같은 이름의 빈을 찾아서 묶어준다.
	//byType : property와 같은 타입의 빈을 찾아서 묶어준다.
	@Autowired
	@Qualifier("h")
	private String name;
	
	public String printName(){
		return "당신의 이름은"+name+"입니다.";
	}
}
```

### ex6_auto.xml

TO-BE

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">
	<!-- 어노테이션 설정시에 선언 -->
	<context:annotation-config/>
	<bean id="str" class="java.lang.String">
		<constructor-arg><value>김길동2</value></constructor-arg>
	</bean>
	<bean id="str2" class="java.lang.String">
		<qualifier value="h"/>
		<constructor-arg><value>트럼푸</value></constructor-arg>
	</bean>
	<bean id="autoBean1" class="ex6.Ex6_AutoWired1">

	</bean>
</beans>
```

Finally

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd">
	<context:annotation-config/>
	<bean id="name1" class="java.lang.String">
		<constructor-arg><value>김길동</value></constructor-arg>
	</bean>
	<bean id="name2" class="java.lang.String">
		<qualifier value="h"/>
		<constructor-arg><value>버럭 오마바</value></constructor-arg>
	</bean>
	<bean id="myauto" class="ex6.Ex6_AutoWired"/>
</beans>
```

## Ex7_Resource

### Ex7_Resource.java

```
package ex6;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

public class Ex7_Resource {
	@Resource(name="msg2")
	private String msg;
	
	public String printMsg(){
		return "당신의 메세지 :"+msg;
	}
}
```

### ex7.res.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd">
	<!-- ex7_res.xml -->
	<context:annotation-config/>
	<bean id="msg1" class="java.lang.String">
		<constructor-arg><value>AOP진도 나갑시다. ^^</value></constructor-arg>
	</bean>
	<bean id="msg2" name="msg3" class="java.lang.String">
		<constructor-arg><value>재미있는 Spring MVC!</value></constructor-arg>
	</bean>
	<bean id="resv" class="ex6.Ex7_Resource"/>

</beans>
```

### ex7_auto1.jsp

```
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
```

----------------------------------------------------------------

# MVC & Restful ( JSON, xml, path value )

- DI (IoC) : MVC 패턴
- Client -> request -> Controller ( Spring container ) -> View ( Response ),  ObjectFactory ( -> Mode -> DAO -> JDBC Template, ORM )
- Controller
  - Spring Container
    - Bean (DI)
  - handleingMapping
    - URL, method
    - Model and view
    - Resolver
    
![mvc-context-hierarchy](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/images/mvc-context-hierarchy.png.pagespeed.ce.LDigfAkmpx.png)
From http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/

## Environment

### New project

- Over Servers > New > Dynamic Web Project
  - Project name : spring0214
  - 'Next'
  - 'Next'
  - Check Generate web.xml deployment descriptor

### To Maven

- Over `spring0214` > `Configure` > `Conver to Maven`

### Add Spring Project Nature

- Over `spring0214` > `Spring Tools` > `Add Spring Project Nature`

### Add dependencies in pom.xml

#### Spring

http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#overview-maven-dependency-management

```
<dependencies>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>4.3.6.RELEASE</version>
    </dependency>
</dependencies>
```

#### Spring JDBC

https://mvnrepository.com/artifact/org.springframework/spring-jdbc/4.3.6.RELEASE

```
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>4.3.6.RELEASE</version>
</dependency>
```

#### Mybatis

https://mvnrepository.com/artifact/org.mybatis/mybatis/3.4.2

```
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.2</version>
</dependency>
```

#### Mybatis Spring

https://mvnrepository.com/artifact/org.mybatis/mybatis-spring/1.3.1

```
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>1.3.1</version>
</dependency>
```

#### Spring Web

- Search web
https://mvnrepository.com/artifact/org.springframework/spring-web/4.3.6.RELEASE

```
<!-- https://mvnrepository.com/artifact/org.springframework/spring-web -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>4.3.6.RELEASE</version>
</dependency>
```

#### Spring web MVC

- Search web mvc
https://mvnrepository.com/artifact/org.springframework/spring-webmvc/4.3.6.RELEASE

```
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>4.3.6.RELEASE</version>
</dependency>
```

#### AspectJ Weaver

- Search aspectjweaver
https://mvnrepository.com/artifact/org.aspectj/aspectjweaver/1.8.10

```
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.8.10</version>
</dependency>
```

### WebContent/WEB_INF/web.xml

AS-IS

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
  <display-name>spring0214</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```

TO-BE

- Copy `org.springframework.web.servlet.DispatcherServlet` in http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/#mvc-servlet

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" id="WebApp_ID" version="3.1">
  <display-name>spring0214</display-name>
  <filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>EUC-KR</param-value>
    </init-param>
    <init-param>
      <param-name>forceEncoding</param-name>
      <param-value>true</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
  <servlet>
  	<servlet-name>kosta</servlet-name>
  	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
  	<servlet-name>kosta</servlet-name>
  	<url-pattern>/</url-pattern>
  </servlet-mapping>
  
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
</web-app>
```

### kosta-servlet.xml

- Add configutaion
  - kosta-servlet.xml
  - `Next`
  - Check `beans`, `context`, `mvc`

- over `WebContent` > New > Folder > `resources`
- Create `css`, `js`, `img` folders in `resources`
- Create `jsp` in `WEB-INF`

- new class
  - package : `or.kosta.mvc.controller`
  - Name : DefaultController
  - `Finish`

AS-IS

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">


</beans>
```

TO-BE

```jsp
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<context:component-scan base-package="or.kosta.mvc" />
	<mvc:annotation-driven />
	<mvc:resources location="/resources/" mapping="/resources/**" />
	<bean
		id="viewResolver"
		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/jsp/" />
		<property name="suffix" value=".jsp" />
	</bean>
</beans>
```

### DefaultController.js

```java
package or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	
	// 기본 페이지 설정
	@RequestMapping(value="/index")
	public String defaultPage() {
		return "index";
	}
}
```

### WebContent\index.jsp

- Over `WebContent` > New > Other
  - Search `JSP` > Select `JSP File`
  - File name : `index.jsp` > `FINISH`

AS-IS
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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

TO-BE
```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	window.onload = function() {
		location = "index"
	};
</script>
</head>
<body>

</body>
</html>
```

### WebContent\WEB-INF\index.jsp

- Over `WEB-INF` > New > Other
  - Search `JSP` > Select `JSP File`
  - File name : `index.jsp` > `FINISH`

```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp/index.jsp</title>
<style>
	body {background: orange;}
</style>
</head>
<body>
	<a href="">첫번째 예제</a>
</body>
</html>
```

### Output

- Over `index.js` in `WebContent`

```
첫번째 예제
```

### HelloContaoller.java in `src`/`or.kosta.mvc.controller`

```
package or.kosta.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloContaoller {

		@RequestMapping(value="/hello", method=RequestMethod.GET)
		public ModelAndView sayHello () {
			ModelAndView mav = new ModelAndView();
			//View의 이름을 지정
			mav.setViewName("sayhello");
			//값을 지정
			mav.addObject("msg", "안녕하세요~^^");
			return mav;
		}
}
```

### sayHello.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>sayhello</title>
</head>
<body>
	<div>
		sayhello : ${msg}
	</div>
</body>
</html>
```

### Update index.jsp in `WebContent` / `WEB-INF` / `jsp`

```jsp
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>jsp/index.jsp</title>
<style>
	body {background: orange;}
</style>
</head>
<body>
	<a href="sayhello">첫번째 예제</a>
</body>
</html>
```

### Output

- Over `index.js` in `WebContent`

```
첫번째 예제
```

- Tap `첫번째 예제`

```
sayhello : 안녕하세요~^^
```





## Reference
- Spring framework basic chapter 1 : http://blog.naver.com/madplay/220641077920
- http://blog.naver.com/javabook
