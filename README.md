# ID1212-WebApp
Homework 4 in course ID1212 at KTH.

Currency converter web application running through docker.

## Infrastructure
* Server: Payara (docker image)
* Database: MongoDB (docker image)
* Built tool: Maven

## Frameworks
* View: JavaServer Faces (JSF)
* Controller: Enterprise JavaBeans (EJB)
* Model/Integration: EclipseLink JPA

## Start Application
``` 
mvn package
docker-compose up
```
Application runs on: `localhost:8080/webapp`

## Open Ports
* 8080 - Payara webserver (HTTP)
* 8181 - Payara webserver (HTTPS)
* 4848 - Payara admin panel
* 27071 - MongoDB
