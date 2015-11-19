<h1>Oracle Spring Boot RESTful demo</h1>

The following demo shows how to use Spring Boot to access your Oracle Database. This demo will be the basis of the 
IBM Bluemix Secure Connector with Oracle demo.

<b>Steps to Create an executable JAR file</b>

1. Clone the project as follows

```
git clone https://github.com/papicella/OracleSpringBootRESTful.git
```

2. Change to directory "OracleSpringBootRESTful"

3. Edit "./src/main/resources/application.properties"

```
oracle.username=scott
oracle.password=tiger
oracle.url=jdbc:oracle:thin:@//192.168.14.132:1521/ora11gr2
```

4. Ensure your oracle database schema has the DEPT table , if not you can create it as follows

```
CREATE TABLE DEPT
       (DEPTNO NUMBER(2) CONSTRAINT PK_DEPT PRIMARY KEY,
     DNAME VARCHAR2(14) ,
     LOC VARCHAR2(13) ) ;
     
 INSERT INTO DEPT VALUES
      (10,'ACCOUNTING','NEW YORK');
 INSERT INTO DEPT VALUES (20,'RESEARCH','DALLAS');
 INSERT INTO DEPT VALUES
      (30,'SALES','CHICAGO');
 INSERT INTO DEPT VALUES
      (40,'OPERATIONS','BOSTON');
      
COMMIT;     
```

5. Package as shown below

```
$ mvn package
```

6. Run as follows

```
pasapicella@192-168-1-5:~/temp/OracleSpringBootRESTful$ java -jar ./target/OracleSpringBootRESTful-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.3.0.RELEASE)


2015-11-19 23:02:59.270  INFO 37763 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2015-11-19 23:02:59.329  INFO 37763 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2015-11-19 23:02:59.333  INFO 37763 --- [           main] b.p.o.OracleSpringBootResTfulApplication : Started OracleSpringBootResTfulApplication in 3.368 seconds (JVM running for 3.697)
```

7. Test as follows

```
$ curl http://localhost:8080/alldeps
```

Now you have a Spring Boot application nusing REST to return all DEPT rows using JSON
