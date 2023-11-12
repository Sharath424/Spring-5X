### Create a simple Spring MVC application

**Step 1**: Set up your project

You can use Spring Initializr to quickly generate a Spring MVC project. Visit [spring.io](https://start.spring.io/) and configure your project as follows:

* Project: Maven Project

* Language: Java

* Spring Boot: (Choose the latest version)

* Group: com.example

* Artifact: spring-mvc-example

* Dependencies: Web and thymeleaf

* Click "Generate" to download the project zip file.

#### Import the project into your IDE

**Step 2**:

* Unzip the downloaded file and import the project into your favorite Java IDE (e.g., IntelliJ, Eclipse, or VS Code) as a Maven project.

* Open STS

* Click on file

* Click on import > select maven > select existing maven project > click next

* Browser the unzipped file

* pom.xml file will appear, select it and click on finish

#### Create a Controller

* In your project, create a new Java class named `HelloController` in the `com.example` package.

* In this controller, we've defined a method `hello` that maps to the URL path `/hello`. It sets a "Hello, World!" message as an attribute in the `Model` and returns the logical view name "hello".

```java
package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model) {
        String message = "Hello, World!";
        model.addAttribute("message", message);
        return "hello";
    }
}

```

#### Create the View

* In the `src/main/resources/templates` directory, create a new HTML file named `hello.html`

* This view template uses Thymeleaf, a popular template engine, to display the message from the controller

```html

<!DOCTYPE html>
<html>
<head>
    <title>Hello, World!</title>
</head>
<body>
    <h1 th:text="${message}"></h1>
</body>
</html>

```
#### Run the application and Access the application

* In your IDE, run the main class (usually named `SpringMvcExampleApplication` or similar). This will start the Spring Boot application.

* Open your web browser and go to `(http://localhost:8080/hello)`. You should see the "Hello, World!" message displayed on the page.


