# FirstspringbootApplication

* Once after the first spring boot application is created, we can run the application.

```java

package com.training.firstspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstspringbootApplication.class, args);
	}

}
```
* Output:

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.1.4)[0;39m

[2m2023-10-17T12:49:13.850+05:30[0;39m [32m INFO[0;39m [35m1256[0;39m [2m---[0;39m [2m[           main][0;39m [36mc.t.f.FirstspringbootApplication        [0;39m [2m:[0;39m Starting FirstspringbootApplication using Java 17 with PID 1256 (C:\Users\admin\Desktop\main\firstspringboot\target\classes started by admin in C:\Users\admin\Desktop\main\firstspringboot)
[2m2023-10-17T12:49:13.862+05:30[0;39m [32m INFO[0;39m [35m1256[0;39m [2m---[0;39m [2m[           main][0;39m [36mc.t.f.FirstspringbootApplication        [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2023-10-17T12:49:14.449+05:30[0;39m [32m INFO[0;39m [35m1256[0;39m [2m---[0;39m [2m[           main][0;39m [36mc.t.f.FirstspringbootApplication        [0;39m [2m:[0;39m Started FirstspringbootApplication in 1.043 seconds (process running for 1.894)
```

* Note: The above output shows that the application is running.

# Convert the application to a web application

* To convert the application to a web application, we need to add the following dependency in the pom.xml file

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```
* Run the application again.

* **Output**:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.1.4)[0;39m

[2m2023-10-17T13:13:57.368+05:30[0;39m [32m INFO[0;39m [35m776[0;39m [2m---[0;39m [2m[           main][0;39m [36mc.t.f.FirstspringbootApplication        [0;39m [2m:[0;39m Starting FirstspringbootApplication using Java 17 with PID 776 (C:\Users\admin\Desktop\main\firstspringboot\target\classes started by admin in C:\Users\admin\Desktop\main\firstspringboot)
[2m2023-10-17T13:13:57.380+05:30[0;39m [32m INFO[0;39m [35m776[0;39m [2m---[0;39m [2m[           main][0;39m [36mc.t.f.FirstspringbootApplication        [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2023-10-17T13:13:58.418+05:30[0;39m [32m INFO[0;39m [35m776[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.b.w.embedded.tomcat.TomcatWebServer [0;39m [2m:[0;39m Tomcat initialized with port(s): 8080 (http)
[2m2023-10-17T13:13:58.430+05:30[0;39m [32m INFO[0;39m [35m776[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.apache.catalina.core.StandardService  [0;39m [2m:[0;39m Starting service [Tomcat]
[2m2023-10-17T13:13:58.431+05:30[0;39m [32m INFO[0;39m [35m776[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.apache.catalina.core.StandardEngine   [0;39m [2m:[0;39m Starting Servlet engine: [Apache Tomcat/10.1.13]
[2m2023-10-17T13:13:58.543+05:30[0;39m [32m INFO[0;39m [35m776[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.a.c.c.C.[Tomcat].[localhost].[/]      [0;39m [2m:[0;39m Initializing Spring embedded WebApplicationContext
[2m2023-10-17T13:13:58.543+05:30[0;39m [32m INFO[0;39m [35m776[0;39m [2m---[0;39m [2m[           main][0;39m [36mw.s.c.ServletWebServerApplicationContext[0;39m [2m:[0;39m Root WebApplicationContext: initialization completed in 1102 ms
[2m2023-10-17T13:13:59.041+05:30[0;39m [32m INFO[0;39m [35m776[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.b.w.embedded.tomcat.TomcatWebServer [0;39m [2m:[0;39m Tomcat started on port(s): 8080 (http) with context path ''
[2m2023-10-17T13:13:59.049+05:30[0;39m [32m INFO[0;39m [35m776[0;39m [2m---[0;39m [2m[           main][0;39m [36mc.t.f.FirstspringbootApplication        [0;39m [2m:[0;39m Started FirstspringbootApplication in 2.074 seconds (process running for 2.81)
```

* Note: The above output shows that the application is running on port 8080 and tomcat is started.

* Run the application on the browser using the url: http://localhost:8080/

* It gives default error page because no explicit endpoint.

* **Output:**

```
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Tue Oct 17 13:20:14 IST 2023
There was an unexpected error (type=Not Found, status=404).
```

# Server port configuration

* if we want to change the server port, we can do it in the application.properties file.

```
server.port=8081
logging.level.org.springframework.web=debug
```

* **Note:** The above code changes the server port to 8081 and also enables the debug mode.

* debug mode: It shows the debug logs in the console.

## Example of a Spring Boot application with component scanning and bean creation

* Create a SpringDemoComponent class

```java
package com.training.firstspringboot;

import org.springframework.stereotype.Component;

@Component
public class SpringDemoComponent {
	
	public SpringDemoComponent() {
		System.out.println("*********Constructor or SpringDemoComponent use called****");
	}
	
	public String getMessage() {
		return "Hello from SpringDemoComponent get message";
	}

}
```
* Create a FirstspringbootApplication class

```java
 package com.training.firstspringboot;

import java.util.Arrays;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstspringbootApplication {

	public static void main(String[] args) {
	    ConfigurableApplicationContext applicationContext =SpringApplication.run(FirstspringbootApplication.class, args);
			SpringDemoComponent component = applicationContext.getBean(SpringDemoComponent.class);
			System.out.println(component.getMessage());
			
			String[] beanNames =applicationContext.getBeanDefinitionNames();
			Arrays.sort(beanNames);//optional
			for(String beanName: beanNames) {
			System.out.println(beanName);
			}
			}
}
```

* The basic working of a Spring Boot application with component scanning and bean creation. Here's a step-by-step explanation of how it works:

1. Spring Boot Application Annotation:

```java
@SpringBootApplication
public class FirstspringbootApplication {
```
- This annotation marks the class as a Spring Boot application and provides a convenient way to enable various Spring Boot features, including component scanning and auto-configuration. It also contains the main method, which serves as the entry point for the application.

2. Main Method:

```java
public static void main(String[] args) {
       ConfigurableApplicationContext applicationContext = SpringApplication.run(FirstspringbootApplication.class, args);
       SpringDemoComponent component = applicationContext.getBean(SpringDemoComponent.class);
       System.out.println(component.getMessage());

       String[] beanNames = applicationContext.getBeanDefinitionNames();
       Arrays.sort(beanNames);
       for (String beanName : beanNames) {
           System.out.println(beanName);
       }
   }
```

- The main method starts the Spring Boot application using SpringApplication.run(). It returns a ConfigurableApplicationContext that represents the Spring application context.

- It retrieves a SpringDemoComponent bean from the context using applicationContext.getBean(SpringDemoComponent.class). The SpringDemoComponent is annotated with @Component, making it a Spring-managed bean.

- It then calls the getMessage method of the SpringDemoComponent and prints the returned message.

- Finally, it retrieves and sorts the names of all the beans defined in the application context and prints them to the console.

3. SpringDemoComponent:

```java
   @Component
   public class SpringDemoComponent {
       public SpringDemoComponent() {
           System.out.println("*********Constructor of SpringDemoComponent is called****");
       }

       public String getMessage() {
           return "Hello from SpringDemoComponent getMessage";
       }
   }
```

- SpringDemoComponent is a simple Spring-managed component marked with the @Component annotation.

- It has a constructor that prints a message when the bean is created.

- It also provides a getMessage method that returns a string.

### Explianation of the above code

1. Spring Boot initializes and creates the application context.

2. During application context initialization, it scans for components (classes annotated with @Component or related annotations).

3. It identifies SpringDemoComponent as a component and creates an instance of it. This triggers the constructor message.

4. The main method retrieves the SpringDemoComponent bean from the application context and calls the getMessage method, printing "Hello from SpringDemoComponent getMessage."

5. It then retrieves and prints the names of all beans defined in the application context, which includes various Spring Boot-related beans and any custom beans you may define.

6. The output of the application will include the constructor message and the "Hello from SpringDemoComponent getMessage" message, along with a list of bean names in the context.

## how to get the bean by using configuration class instead of @Component annotation

* Create a SpringConfig class

```java
package com.training.firstspringboot;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;

@Configuration
public class SpringConfig {

	@Bean
	public SpringDemoComponent createBean() {
		return new SpringDemoComponent();
	}
}
```

* Remove the @Component annotation from the `SpringDemoComponent` class.

```java
package com.training.firstspringboot;

public class SpringDemoComponent {
	
	public SpringDemoComponent() {
		System.out.println("*********Constructor or SpringDemoComponent use called****");
	}
	
	public String getMessage() {
		return "Hello from SpringDemoComponent get message";
	}

}
```

### Working of the above code

1. FirstspringbootApplication:

* @SpringBootApplication annotation indicates that this class is a Spring Boot application. It includes several other annotations and configures various aspects of your application.

* In the main method, you start the Spring Boot application by calling SpringApplication.run(FirstspringbootApplication.class, args). This line initializes the Spring context and application, and it returns a ConfigurableApplicationContext object.

2. SpringDemoComponent:

* This is a simple Java class that serves as a Spring bean. It contains a constructor and a getMessage method.

* The constructor includes a print statement to indicate when it's called. It's used to demonstrate that Spring manages the creation of beans.

3. SpringConfig:

* This class is marked with the @Configuration annotation, which indicates that it contains Spring bean configuration information.

* Inside the class, there is a method annotated with @Bean, which defines a bean named createBean. This method returns an instance of SpringDemoComponent.

Now, let's explain how these components work together:

1. When you run the FirstspringbootApplication, it starts the Spring Boot application and initializes the Spring context.

2. In the main method, you obtain a reference to the SpringDemoComponent bean by calling applicationContext.getBean(SpringDemoComponent.class). This bean is automatically created and managed by Spring due to the presence of @SpringBootApplication.

3. You call the getMessage method on the SpringDemoComponent bean, which returns a simple message.

4. The SpringConfig class is a configuration class. The createBean method is marked with @Bean, which tells Spring to create and manage a bean named createBean using the SpringDemoComponent class.

5. When you obtain the SpringDemoComponent bean in your main method, you also see the constructor of SpringDemoComponent being called. This demonstrates that Spring has created an instance of SpringDemoComponent and injected it where required.

6. Finally, you retrieve and print the names of all beans defined in the application context, demonstrating how to list all the beans available in the Spring context.

* **Output**:

```java
*********Constructor of SpringDemoComponent is called****
Hello from SpringDemoComponent get message
```

This output shows that the constructor of SpringDemoComponent is called during bean creation, and the getMessage method returns the message from the bean. Additionally, any other beans defined in your application context would be listed in alphabetical order in the console output.

## Conditional way of bean creation

* Create a springdemocomponent based on some condition

* Create a MyCondition class where we can write coustom condition

```java
package com.training.firstspringboot;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		return true;
	}


}
```

* Add @Conditional in SpringConfig class

```java
package com.training.firstspringboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

	@Bean
	@Conditional(MyCondition.class)
	public SpringDemoComponent createBean() {
		return new SpringDemoComponent();
	}
}
```

* write a CommandLineRunner method

```java

package com.training.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstspringbootApplication implements CommandLineRunner{
	
	@Autowired
	SpringDemoComponent springDemoComponent;

	public static void main(String[] args) {
			
			 SpringApplication.run(FirstspringbootApplication.class, args);
			   
			
			}
			
	@Override
	public void run(String... args) throws Exception{
		System.out.println(springDemoComponent.getMessage());
	}
}
```

* **Output:**

```java
*********Constructor of SpringDemoComponent is called****
Hello from SpringDemoComponent get message
```

### Explanation of the above code

1. MyCondition Class:

* This class implements the Spring Condition interface. The Condition interface provides a way to specify whether a bean should be created based on certain conditions.

* The matches method is overridden and currently always returns true. In a real application, you would typically implement custom logic here to evaluate whether the condition is met.

2. SpringConfig Class:

* This is a Spring configuration class annotated with @Configuration, indicating that it contains Spring bean definitions.

* The createBean method is annotated with @Bean and @Conditional(MyCondition.class). This means that the SpringDemoComponent bean will be created if the condition defined in MyCondition is met. In this case, MyCondition always returns true, so the SpringDemoComponent bean will be created.

3. FirstspringbootApplication Class:

* This is the main class of your Spring Boot application, and it's annotated with @SpringBootApplication, indicating that it's a Spring Boot application.

* It implements the CommandLineRunner interface, which allows you to execute custom code when the application starts.

* In the main method, you start the Spring Boot application using SpringApplication.run(FirstspringbootApplication.class, args);. This initializes the Spring context and starts the application.

* In the run method (required by the CommandLineRunner interface), you use the springDemoComponent bean to print a message.

When application is running the following sequence of actions occurs:

* The main method is executed, and the Spring Boot application is started.

* The Spring context is initialized, and the SpringDemoComponent bean is created. However, the MyCondition condition is evaluated, and since it always returns true, the SpringDemoComponent bean is created without any issues.

* The run method is executed, which retrieves the springDemoComponent bean and prints the message returned by the getMessage method of the SpringDemoComponent.

**Output:**

```java
*********Constructor of SpringDemoComponent is called****
Hello from SpringDemoComponent get message
```

This output indicates that the SpringDemoComponent bean is successfully created and used in your application.

## get the value from application.properties file

```java
package com.training.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstspringbootApplication implements CommandLineRunner{
	
	@Autowired
	SpringDemoComponent springDemoComponent;

    @Value("${server.port}")
	private String port; 

	public static void main(String[] args) {
			
			 SpringApplication.run(FirstspringbootApplication.class, args);
			   
			
			}
			
	@Override
	public void run(String... args) throws Exception{
		System.out.println(springDemoComponent.getMessage());
        	System.out.println("the server port is :"+ port);
	}
}
```
* **output:**

```java
*********Constructor of SpringDemoComponent is called****
Hello from SpringDemoComponent get message
the server port is :8081
```

### Creating the profile specific properties file

* add the following code in the application.properties file

```
server.port=8081
spring.profiles.active=dev
```

* **Note:** The above code activates the dev profile.

* Create a application-dev.properties file

```
server.port=8082
```

* run the application

* **Output:**

```
*********Constructor of SpringDemoComponent is called****
Hello from SpringDemoComponent get message
the server port is :8082
```

## Creating a simple @RestController class

* Create a HelloWorldController class in the same package

```java
package com.training.firstspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello web";
		
	}
}
```

* Run the application

* go to the browser and type the url: http://localhost:8082/

* **Output:**

```java
Hello web
```

* now add the endpoint in the HelloWorldController class

```java
package com.training.firstspringboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	
	@GetMapping("/ hello")
	public String sayHello() {
		return "Hello web";
		
	}
}
```

* run the application and go to the browser and type the url: http://localhost:8082/hello

* **Output:**

```
Hello web
```

* if we try to run localhost:8082/ it gives default error page because no explicit endpoint.

### To return a json response we can add a complex object in the HelloWorldController class

* Create a HelloWeb class in the same package with getters and setters

```java
package com.training.firstspringboot;
import org.springframework.stereotype.Component;


@Component
public class HelloWeb {

	private Integer id;
	
	private String message ;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

```

* add the following code in the HelloWorldController class

```java
package com.training.firstspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@Autowired
	HelloWeb helloWeb;
	
	@GetMapping()
	public String defaultWeb() {
		return "Hello world";
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello web";
		
	}
	
	@GetMapping("/helloweb")
	public HelloWeb sayHelloWithObject() {
		helloWeb.setId(1);
		helloWeb.setMessage("Hello web!");
		return helloWeb;
		
	}
}
```

* run the application and go to the browser and type the url: http://localhost:8082/helloweb

* **Output:**

```json
{
"id": 1,
"message": "Hello web!"
}
```

## Unit testing of the application for the above code

* dependency for the unit testing is already added in the pom.xml file

```xml
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
```

* go to src/test/java and in the created package com.training.firstspringboot there will be a FirstspringbootApplicationTests class

```java
package com.training.firstspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstspringbootApplicationTests {

    @Test
    void contextLoads() {
    }

}
```

* lets do the negative testing by removing the @SpringBootApplication annotation from the FirstspringbootApplication class

* run the application as JUnit test and go to the console and see the output

* **Output:**

```java
java.lang.IllegalStateException: Unable to find a @SpringBootConfiguration, you need to use @ContextConfiguration or @SpringBootTest(classes=...) with your test
	at org.springframework.util.Assert.state(Assert.java:76)
	at org.springframework.boot.test.context.SpringBootTestContextBootstrapper.findConfigurationClass(SpringBootTestContextBootstrapper.java:260)
	at org.springframework.boot.test.context.
```

* Note: The above output shows that the application is not running because the @SpringBootApplication annotation is removed.

### Test cases for helloWorldController class

* go to src/test/java and in the FirstspringbootApplicationTests class add the following code

```java
package com.training.firstspringboot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FirstspringbootApplicationTests {

	@Autowired
	private HelloWorldController controller;

	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoadsWithControllerSuccess() {
		assertThat(controller).isNotNull();
		
	}

}
```

* run the application as JUnit test and go to the console and see the output

* note: The above code checks whether the controller is null or not.
 
* test case will pass if the controller is not null.

### Test Case to check weather the controller is returning the correct response or not

* go to src/test/java and create a HelloResourceControllerWebLayerTest class

```java
package com.training.firstspringboot;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
public class HelloResourceControllerWebLayerTest {

	@Autowired
	public MockMvc mockMvc;

	@Test
	public void sayHelloShouldReturnDefaultMessage() throws Exception{
		this .mockMvc.perform(get("/hello")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello web")));
	}
}
```

* run the application as JUnit test and go to the console and see the output

* **Output:**

```java
13:25:25.347 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils -- Could not detect default configuration classes for test class [com.training.firstspringboot.HelloResourceControllerWebLayerTest]: HelloResourceControllerWebLayerTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
13:25:25.626 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper -- Found @SpringBootConfiguration com.training.firstspringboot.FirstspringbootApplication for test class com.training.firstspringboot.HelloResourceControllerWebLayerTest

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.1.4)

2023-10-18T13:25:26.938+05:30  INFO 19616 --- [           main] .t.f.HelloResourceControllerWebLayerTest : Starting HelloResourceControllerWebLayerTest using Java 17 with PID 19616 (started by admin in D:\office projects\Spring-5.x\springboot-2.7.8\firstspringboot)
2023-10-18T13:25:26.942+05:30  INFO 19616 --- [           main] .t.f.HelloResourceControllerWebLayerTest : The following 1 profile is active: "dev"
*********Constructor or SpringDemoComponent use called****
2023-10-18T13:25:28.545+05:30  INFO 19616 --- [           main] o.s.b.t.m.w.SpringBootMockServletContext : Initializing Spring TestDispatcherServlet ''
2023-10-18T13:25:28.545+05:30  INFO 19616 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Initializing Servlet ''
2023-10-18T13:25:28.550+05:30  INFO 19616 --- [           main] o.s.t.web.servlet.TestDispatcherServlet  : Completed initialization in 2 ms
2023-10-18T13:25:28.606+05:30  INFO 19616 --- [           main] .t.f.HelloResourceControllerWebLayerTest : Started HelloResourceControllerWebLayerTest in 2.851 seconds (process running for 4.733)
Hello from SpringDemoComponent get message
the server port is :8082

MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /hello
       Parameters = {}
          Headers = []
             Body = null
    Session Attrs = {}

Handler:
             Type = com.training.firstspringboot.HelloWorldController
           Method = com.training.firstspringboot.HelloWorldController#sayHello()

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = null
             View = null
            Model = null

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"text/plain;charset=UTF-8", Content-Length:"9"]
     Content type = text/plain;charset=UTF-8
             Body = Hello web
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
```

* Note: The above output shows that the test case is passed.

* Note : if you get error like this `Action: Consider defining a bean of type 'com.training.firstspringboot.SpringDemoComponent' in your configuration.` add the component scan in the FirstspringbootApplication class




