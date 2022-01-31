# Java 3 Final Project

This is the final project for my CIS-181 Java III course at Kirkwood Community College. Below is a journal of all the things I learned throughout the class.

## Deployment

*[Amazon Web Servies](http://java3spring2022-env.eba-2geyu3hp.us-east-1.elasticbeanstalk.com/register.html)

*[Heroku](salty-savannah-73662.herokuapp.com/)

*[Microsoft Azure](https://java3finalproject2022.azurewebsites.net)

## Project Setup

## Chapter 1 and 2

In chapters 1 and 2 I learned about:

- Java EE
- Multi-Tiered Applications
- Web Application Servers (Web Containers)
- Environment Variables

Java Enterprise Edition (EE) is a way for web servers to interact with Java Servlets, JSPs, and other Java Technologies. This facilitates Multi-Tiered Applications by connecting the client to the server, making up 2 tiers.

Web Applications Servers, also known as Web Containers, let Web Servers work with Java EE. The Web Container I'm using for this class is Apache's Tomcat.

Environment Variables store paths so that the system can find certain files. For example the JAVA_HOME environment variable holds the path of a JDK to be used by other software like Windows Command Prompt. When installing Tomcat I added a CATALINA_HOME environment variable.