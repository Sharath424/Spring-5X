# Spring Interceptor

**Step 1**: Set up your project

You can use Spring Initializr to quickly generate a Spring MVC project. Visit [spring.io](https://start.spring.io/) and configure your project as follows:

* Project: Maven Project

* Language: Java

* Spring Boot: (Choose the latest version)

* Group: com.example

* Artifact: spring-interceptor-example

* Dependencies: Web 

* Click "Generate" to download the project zip file.

## Import the project into your IDE

**Step 2**:

* Unzip the downloaded file and import the project into your favorite Java IDE (e.g., IntelliJ, Eclipse, or VS Code) as a Maven project.

* Open STS

* Click on file

* Click on import > select maven > select existing maven project > click next

* Browser the unzipped file

* pom.xml file will appear, select it and click on finish




## Spring Interceptor Code Example

Spring interceptor is used to perform certain actions before and after handling HTTP requests. 

1. **HelloController**:
   
This class is a Spring MVC controller. It handles requests to the `/hello` endpoint and returns a "Hello, Spring Interceptor!" response. The `@GetMapping` annotation maps the `hello` method to HTTP GET requests, and the `@ResponseBody` annotation indicates that the return value should be treated as the response body.

2. **InterceptorsApplication**:
   
This class is the main entry point of your Spring Boot application. It is annotated with `@SpringBootApplication`, which is a meta-annotation that includes several other annotations, including `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. It contains the `main` method, which launches the Spring Boot application.

3. **LoggingInterceptor**:

This class is an implementation of the Spring `HandlerInterceptor` interface. It defines methods for pre-processing (`preHandle`), post-processing (`postHandle`), and after completion (`afterCompletion`) of HTTP requests.

   - `preHandle`: This method is executed before the actual request handling by controllers. In the code, it simply logs "Pre-handle method is called" to the console. Returning `true` from this method allows the request to continue processing.
   - `postHandle`: This method is executed after the controller method has completed but before the view is rendered. In the code, it logs "Post-handle method is called."
   - `afterCompletion`: This method is executed after the response is sent to the client. In the code, it logs "After-completion method is called."

4. **WebMvcConfig**:

This class is a Spring configuration class that implements the `WebMvcConfigurer` interface. It is used to configure Spring MVC, including registering interceptors. The `addInterceptors` method is overridden to add the `LoggingInterceptor` to the interceptor registry. In the code, it is configured to apply the interceptor to all URL paths with `"/**"`, meaning it will be triggered for all requests.

The purpose of this setup is to demonstrate how the `LoggingInterceptor` is triggered before and after each HTTP request to provide more detailed information about request handling in the application.

When you run your Spring Boot application and access the `/hello` endpoint, you'll see output in the console like this:

```
Pre-handle method is called
Post-handle method is called
After-completion method is called
```

This output indicates that the interceptor's `preHandle` method is executed before the controller's `hello` method, and the `postHandle` and `afterCompletion` methods are executed afterward. The output is a result of the interceptor's actions before and after request processing.

### Configure the pom.xml by adding additional dependency

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.2</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>interceptors</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>interceptors</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.0.1</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

```

### Create a java class in the package 

* **Hello Controller.java**

```java
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring Interceptor!";
    }
}
```

* **InterceptorsApplication.java**

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InterceptorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterceptorsApplication.class, args);
	}

}
```

* **LoggingInterceptor.java**

```java
package com.example.demo;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggingInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Pre-handle method is called");
        return true; // Continue processing the request
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("Post-handle method is called");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("After-completion method is called");
    }
}

```

* **WebMvcConfig.java**

```java
package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggingInterceptor()).addPathPatterns("/**");
    }
}
```

### Run the application

* In your IDE, run the main class (usually named `SpringMvcExampleApplication` or similar). This will start the Spring Boot application.

* Open your web browser and go to `(http://localhost:8080/hello)`. You should see the "Hello, World!" message displayed on the page.

* in console you will get the output

```java
Pre-handle method is called
Post-handle method is called
After-completion method is called
```