# spring-data-jpa-rest
A practice for 
JPA by spring-data + hibernate + bonecp + mysql
RESTful API by spring-data-rest



Download and maven install
----
>git clone https://github.com/whylu/spring-data-jpa-rest.git

>cd spring-data-jpa-rest.git

>mvn install


Prepare
----
prepare a mysql DB named "spring-data-jpa-with-rest" (you can name it if you like)


Configuration
----
change the conf at
> src\main\resources\db.properties

change the jdbc.driver, jdbc.url, jdbc.username, jdbc.password


Run
----
run the this example to insert some data
>mvn exec:java -Dexec.mainClass="demo.run.jpa.JpaExampleRunner01"
The tables "fourm", "post", "recommend", "crawlrecord" should be created and insert some data.


.war is under target
put the .war to tomcat/webapp (apache-tomcat-7.0.32 is good to go)
and start tomcat


REST API
----
##GET
    http://localhost:28080/spring-jpa-with-rest/api
    
##insert example 1
    POST
        http://localhost:28080/spring-jpa-with-rest/api/forums
        Content-Type = application/json
    BODY:
        {
          "key": "insert1"
        }

        
##insert example 2  with a Embedded Entity References 
    POST
        http://localhost:28080/spring-jpa-with-rest/api/posts
        Content-Type = application/json
    BODY:
        {
          "key": "insert_post_1",
          "forum": "http://localhost:28080/spring-jpa-with-rest/api/forums/4"
        }


##update example 1  make a association link for post to foruem (many to one)
    PUT  
        http://localhost:28080/spring-jpa-with-rest/api/posts/6/forum
        Content-Type:text/uri-list
    BODY
        http://localhost:28080/spring-jpa-with-rest/api/forums/4
        



Configuration
----
the config for JPA at 
    /src/main/resources/applicationContext.xml
the config for REST at
    /src/main/java/demo/config/CustomizedRestMvcConfiguration.java


