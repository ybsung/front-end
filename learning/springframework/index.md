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


## Reference
- Spring framework basic chapter 1 : http://blog.naver.com/madplay/220641077920
