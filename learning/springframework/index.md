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
    - Launch `C:\SpringBasic\spring-tool-suite-3.8.3.RELEASE-e4.6.2-win32-x86_64\sts-bundle\sts-3.8.3.RELEASE\sts.exe`
      - Select workspace : `C:\SpringBasic\workspace`
  - Tomcat
    - http://tomcat.apache.org/download-90.cgi
    - http://apache.tt.co.kr/tomcat/tomcat-9/v9.0.0.M17/bin/apache-tomcat-9.0.0.M17-windows-x64.zip
    - Unzip it into `C:\SpringBasic\service\`
  

## Reference
- Spring framework basic chapter 1 : http://blog.naver.com/madplay/220641077920
