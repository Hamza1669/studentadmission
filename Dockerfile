FROM openjdk:17
ADD target/studentadmission.jar studentadmission.jar
ENTRYPOINT [ "java","-jar","/studentadmission.jar" ]