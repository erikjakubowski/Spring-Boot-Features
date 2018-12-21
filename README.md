# SPRINGBOOT DEMO

Features:  
-Comandline runner  
-Spring Boot Starter    
-Schedule executors  
-Interceptors/Converters/Formatters  
-Auto-configuration and Custom Beans  
-Testing REST and JPA with mulitple frameworks  
-ORM Relationships  


# Required  Java 8 and Gradle

Run Application  
Build executable .jar from root directory  
$ ./gradlew clean build  
Then run  
$ java -jar build/lib/spring_demo-1.0-SNAPSHOT.jar  
View Customer @ http://localhost:8080/v1/customer/  

Run Tests  
$ .gradlew clean test  
Open index.html generated -> (project root)/build/reports/test/  

