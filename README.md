# Java 3 Final Project

This is the final project for my CIS-181 Java III course at Kirkwood Community College. Below is a journal of all the things I learned throughout the class.

## Deployment

* [Amazon Web Servies](http://java3spring2022-env.eba-2geyu3hp.us-east-1.elasticbeanstalk.com/register.html)

* [Heroku](salty-savannah-73662.herokuapp.com/)

* [Microsoft Azure](https://java3finalproject2022.azurewebsites.net)

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

## Chapter 3

In chapter 3 I learned about:

- The HttpServlet interface
- POJOs
- HttpServletRequest and HttpServletResponse

The HttpServlet interface is the interface that JavaEE Servlets must extend to be a Servlet. The Servlet must override doPost, doGet, doPut, or doDelete.

In the world of Servlets, POJOs, or Plain Old Java Objects, are any class that doesn't extend HttpServlet.

Each of the methods from the HttpServlet interface that I previously mentioned takes both an HttpServletRequest object and an HttpServletResponse object. HttpServletRequest allows the Servlet to retrieve requests and data from the client. HttpServletResponse allows the Servlet to send information back to the client.

## Chapter 4

In chapter 4 I learned about:

- Java Server Pages (JSP)
- .env files
- Sending and responding to text and voice messages using Twilio

A Java Server Page, or JSP is a file that contains HTML and/or scripts that the server uses to generate HTML using Java. Java code in a JSP goes tags. These include the directive tag <%@ %>, the declaration tag <%! %>, the scriptlet tag <% %>, and the expression tag <%= %>.

A .env file is used to store environment variables for a project. In this chapter I used a .env file to store authentication information for Twilio so that I could put my code on GitHub without exposing that information. When using a .env file for this purpose, it is important to remember to add .env to the .gitignore file.

More than anything, learning to use Twilio was an interesting way to practice and learn more general concepts such as using JSPs, validating form data, using .env files, and adding libraries to a project using Maven.
