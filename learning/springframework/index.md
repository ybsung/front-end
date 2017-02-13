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
  - JDK
    - `java -version`
    - `javac`
  - 7zip : http://www.7-zip.org/
  - Spring
    - Spring Tool Suite : https://spring.io/tools/sts/all
    - Spring Framework : http://projects.spring.io/spring-framework/ 

## Reference
- Spring framework basic chapter 1 : http://blog.naver.com/madplay/220641077920
