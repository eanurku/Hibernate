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

 
3. hibernate.cfg.xml file need to be in proper location in Application war file:
    WEB_INF/Classes/hibernate.cfg.xml
    WEB_INF/Classes/com/
4.
    
    
