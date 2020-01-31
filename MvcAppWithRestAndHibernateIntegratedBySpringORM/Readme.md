1.  ant setup
   see readme.md in https://github.com/eanurku/AntBasics 
2. create Rest Service :
  Add below jars in classpath:
  ----------------------------- 
* add spring jars:
    spring-aop
    spring-beans
    spring-context
    spring-core
    spring-expression
    spring-jcl
    spring-web
    spring-webmvc
    
* add converters jars for json:
    jackson-annotations-2.9.8.jar
    jackson-core-2.9.8.jar
    jackson-databind-2.9.8.jar

* add xml converter jars
    jackson-dataformat-xml-2.8.1.jar
    
    ddependencies:
    jackson-annotations-2.9.8.jar
    jackson-core-2.9.8.jar
    jackson-databind-2.9.8.jar
    jackson-module-jaxb-annotations-2.8.1.jar
    woodstox-core-5.0.2.jar
    stax2-api-3.1.4.jar
* add ORM Jars
    spring-orm-5.1.9.RELEASE.jar
    spring-orm-5.1.9.RELEASE-javadoc.jar
    spring-orm-5.1.9.RELEASE-sources.jar
    
        
3. add mysql connector jar:
    mysql-connector-java-8.0.18.jar
4. add hibernate jars
5. hibernate.cfg.xml file need to be in classpath location in Application war file:
    WEB_INF/Classes/hibernate.cfg.xml
    WEB_INF/Classes/com/

6.Start/Stop Rest Web  Service
    start the tomcat service:
        go to apache-tomcat-9.0.16/bin/
        run ./startup.sh
    install application war file in tomcat:
        ant  install
    uninstall previous war file and install latest war in tomcat:
        ant uninstall install
    launch the rest service now.....
        http://localhost:8080//RestAppWithHibernate/test
        http://localhost:8080//RestApp0/addEmployee
    stop tomcat service:
        go to apache-tomcat-9.0.16/bin/
        run ./shutdown.sh

7.war file structure:
APP/META-INF
APP/index.html

8.Access Jsp page by url:
http://localhost:8080//MvcAppWithRestAndHibernate/
http://localhost:8080//MvcAppWithRestAndHibernate/index.html

-------------------------
hibernate validator 
-------------------------

1. add  hibernate validator  jars in classpath:
 classmate-1.3.4.jar
 hibernate-validator-6.1.0.Final.jar
 jakarta.el-3.0.3.jar
 jakarta.validation-api-2.0.2.jar
 jboss-logging-3.3.2.Final.jar


--------------------
Mvc
--------------------
1.  add servlet jar in classpath:
    javax.servlet-api-3.1.0.jar 
    
    
-------------------------------
Date Mapping:

1.default format accepted by @modelattribute for mapping to Date is:
   MM/dd/yyyy
   ex:
   <td> <input type="text" name="studentDob"/> </td>
   
   so use 12/03/1991 value for above form box.

2. html form date type will pass to modelattribute in format as given below:

   <td> <input type="date" name="studentDob"/> </td>
   
   so netry from above box will be converted internally by html to below format and then passed on to spring:
   yyyy-MM-dd
   ex:
      <td> <input type="date" name="studentDob"/> </td>
      from log in spring:
      {studentName=anurag, studentContact=12, studentDob=2019-05-02}
3.collection of basic types like String
    https://stackoverflow.com/questions/5867130/hibernate-liststring
    https://www.callicoder.com/hibernate-spring-boot-jpa-element-collection-demo/
          
4.
       ----------------------
      GET http://localhost:8080/MvcAppWithRestAndHibernate/getStudentDetail/76
     
      <Student>
      <student_id>79</student_id>
      <student_name>anurag</student_name>
      <student_contact>21</student_contact>
      <student_skills>
      <student_skills>
      <skill_id>12</skill_id>
      <skill_name>sk11</skill_name>
       </student_skills>
      <student_skills>
      <skill_id>13</skill_id>
      <skill_name>sk22</skill_name>
       </student_skills>
       </student_skills>
       </Student>
       
      {"student_id":79,
       "student_name":"anurag",
       "student_contact":21,
       "student_skills":[{"skill_id":12,"skill_name":"sk11"},
        {"skill_id":13,"skill_name":"sk22"}]
        }
5.
      POST http://localhost:8080/MvcAppWithRestAndHibernate/addStudent1
      
      <Student>
          <student_name>anurag</student_name>
          <student_contact>21</student_contact>
              <student_skills>
                  <student_skills>
                  <skill_name>sk11</skill_name>
                  </student_skills>
                  <student_skills>
                  <skill_name>sk22</skill_name>
                  </student_skills>
              </student_skills>
      </Student>
      
      {
          "student_name":"anurag",
          "student_contact":21,
          "student_skills":
              [
                  {"skill_name":"sk11"},
                  
                  {"skill_name":"sk22"}
              ]
      }
      
       
7.POST: 
http://localhost:8080//MvcAppWithRestAndHibernateIntegratedBySpringORM/addStudent2
       <Student>
           <studentAddress>
               <address_id>4</address_id>
               <address_country>india</address_country>
               <address_state>bh</address_state>
               <address_city>sm</address_city>
               <address_pin>1232</address_pin>
            </studentAddress>
           <student_id>83</student_id>
           <student_name>anurag1</student_name>
           <student_contact>21</student_contact>
           <student_skills>
               <student_skills>sk11</student_skills>
               <student_skills>sk22</student_skills>
            </student_skills>
        </Student>
        
        
8 POST 
http://localhost:8080//MvcAppWithRestAndHibernateIntegratedBySpringORM/addEmployee
 {
"firstname": "monua",
"lastname": "l99",
"salary": 2.131
}

