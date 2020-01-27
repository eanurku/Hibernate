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

 
3. hibernate.cfg.xml file need to be in classpath location in Application war file:
    WEB_INF/Classes/hibernate.cfg.xml
    WEB_INF/Classes/com/

4.Start/Stop Rest Web  Service
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
5.Get Test:
    method url
    GET     http://localhost:8080//RestAppWithHibernate/test
    Accept:json
6.POST :insert in DB
    method url
    POST    http://localhost:8080/RestAppWithHibernate/addEmployee
    Headers:
    Accept:application/xml
    Content-Type:application/xml
    Body:
    <Employee>
    	<firstname>anurag</firstname>
    	<lastname>kum</lastname>
    </Employee>
    Response:
    <Boolean>true</Boolean>