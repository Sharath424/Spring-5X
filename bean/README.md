# bean-example

**Step 1**: Go to [spring initializr](#spring-initializr)

**Step 2**: Create the project with dependency

**Step 3**: Unzip the created file

**Step 4**: Open STS

**Step 5**: Click on file

**Step 6**: Click on import > select maven > select existing maven project > click next 

![Spring :import](images/import.png)


**Step 7**: Browser the unzipped file 

![Spring :maven](images/maven.png)

**step 8**: pom.xml file will appear, select it and click on finish

**Folder structure**

![Spring :folder-of-springbootapplication](images/prototype.png)

**Note:** The above steps are similar for session,singleton and request

## Create a java class in the package for prototype

* Right click on the package > `select the new` > `click on class`

* AppConfig.java

```java
package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean
    @Scope("prototype")
    public Message message() {
        return new Message("Hello, Spring!");
    }
}
```

* Message.java

```java
package com.example.demo;

public class Message {
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
```

* PrototypeApplication.java

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrototypeApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Message message1 = context.getBean(Message.class);
        System.out.println("Message 1: " + message1); // This will invoke the overridden toString() method

        Message message2 = context.getBean(Message.class);
        System.out.println("Message 2: " + message2); // This will also invoke the overridden toString() method

        context.close();
    }
}

```

## Output

```java
Message 1: com.example.demo.Message@2f40e5db
Message 2: com.example.demo.Message@517566b

```



### pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>prototype</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>prototype</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
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
### prototype Explanation

1. `AppConfig.java`: This class is annotated with `@Configuration` and defines a Spring bean named `message`. The `message` bean is configured with a prototype scope, which means that a new instance of the `Message` class will be created every time it is requested from the Spring container.

2. `Message.java`: This class defines a simple `Message` object with a text field. The text field is set through the constructor when a new `Message` object is created.

3. `PrototypeApplication.java`: This is the main class of the Spring Boot application. It does the following:

   - It's annotated with `@SpringBootApplication`, indicating that this is a Spring Boot application.
   - In the `main` method, it creates an `AnnotationConfigApplicationContext` based on the configuration defined in `AppConfig`.
   - It retrieves two instances of the `Message` bean from the Spring container using `context.getBean(Message.class)` and prints their texts.
   - Since the `message` bean is prototype-scoped, two separate instances of the `Message` class are created, and their texts are printed.

Here's a brief overview of the application's flow:

1. The `AnnotationConfigApplicationContext` is created, and the configuration defined in `AppConfig` is loaded.

2. Two instances of the `Message` bean are requested from the Spring container using `context.getBean(Message.class)`. This triggers the creation of two separate `Message` objects with different text values.

3. The texts of both `Message` objects are printed, showing that they are indeed separate instances.

4. Finally, the application context is closed.

## Create a java class in the package for Singleton

* Right click on the package > `select the new` > `click on class`

* AppConfig.java

```java
package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Counter counter() {
        return new Counter();
    }
}
```

* Counter.java

```java
package com.example.demo;

public class Counter {
    private int count = 0;

    public int increment() {
        return ++count;
    }

    public int getCount() {
        return count;
    }
}
```

* SIngletonApplication.java

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Counter counter1 = context.getBean(Counter.class);
        System.out.println("Counter 1: " + counter1); // Print the object, will invoke toString() method
        counter1.increment();
        System.out.println("Counter 1 - After Increment: " + counter1);

        Counter counter2 = context.getBean(Counter.class);
        System.out.println("Counter 2: " + counter2);

        context.close();
    }
}

```

### Output

```java
Counter 1: com.example.demo.Counter@4612b856
Counter 1 - After Increment: com.example.demo.Counter@4612b856
Counter 2: com.example.demo.Counter@4612b856
```

### Singleton Working

1. `AppConfig.java`: This class is annotated with `@Configuration` and defines a Spring bean named `counter`. The `counter` bean is configured with the default singleton scope, meaning there will be only one instance of the `Counter` class created and shared across the entire application.

2. `Counter.java`: This class represents a simple counter with a count field. The `increment` method increases the count by one, and the `getCount` method returns the current count.

3. `SingletonApplication.java`: This is the main class of the Spring Boot application. It does the following:

   - Creates an `AnnotationConfigApplicationContext` and loads the configuration defined in `AppConfig`.

   - Retrieves an instance of the `Counter` bean (`counter1`) from the Spring container and prints its initial count.

   - Increments `counter1` and prints its count again to demonstrate that it's the same instance across multiple calls.

   - Retrieves another instance of the `Counter` bean (`counter2`) from the Spring container and prints its initial count. This demonstrates that even though a new variable is declared, it refers to the same singleton instance as `counter1`.

   - Finally, the application context is closed.

Here's a brief overview of the application's flow:

1. The Spring application context is created and configured based on `AppConfig`, which defines a singleton-scoped `Counter` bean.

2. `counter1` is retrieved and incremented, demonstrating that there's only one instance of the `Counter` bean, and changes are reflected across different parts of the application that use it.

3. A separate reference `counter2` is obtained, but it still points to the same singleton instance, as demonstrated by its initial count being the same as `counter1`.

4. The application context is closed, releasing any resources associated with it.


## Create a java class in the package for request

* Right click on the package > `select the new` > `click on class`

* AppConfig.java

```java
package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
public class AppConfig {
    @Bean
    @RequestScope
    public User user() {
        return new User("Swayaan");
    }
}
```
* User.java

```java
package com.example.demo;

public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
```
* UserController.java

```java
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private User user;

    @GetMapping("/user")
    @ResponseBody
    public String getUser() {
        return "Username: " + user.getUsername();
    }
}
```

* RequestApplication.java

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestApplication.class, args);
	}

}
```
### request working

1. `AppConfig.java`: This class is annotated with `@Configuration` and defines a Spring bean named `user`. The `user` bean is configured with a request scope using `@RequestScope`. This means that a new instance of the `User` class will be created for each HTTP request.

2. `User.java`: This class defines a simple `User` object with a username field. The username field is set through the constructor when a new `User` object is created.

3. `UserController.java`: This is a Spring `@Controller` class responsible for handling HTTP requests. It has a field `user` that is annotated with `@Autowired`, which means it will be automatically injected with the `User` bean.

   - The `getUser` method is mapped to the `/user` endpoint using `@GetMapping("/user")`. When this endpoint is accessed, it returns a response containing the username obtained from the `user` bean.

4. `RequestApplication.java`: This is the main class of the Spring Boot application. It's annotated with `@SpringBootApplication`, indicating that this is a Spring Boot application.

Here's a brief overview of the application's flow:

1. The Spring Boot application starts, and the `User` bean is configured with request scope.

2. When an HTTP request is made to the `/user` endpoint, the `UserController` is invoked.

3. The `UserController` uses the `user` bean, which is request-scoped. This means that a new instance of the `User` class is created for each HTTP request, and the username is retrieved from this instance.

4. The username is included in the HTTP response, and it is returned to the client.

## Create a java class in the package for session

* Right click on the package > `select the new` > `click on class`

* AppConfig.java

```java
package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@Configuration
public class AppConfig {
    @Bean
    @SessionScope
    public Cart cart() {
        return new Cart();
    }
}
```

* Cart.java

```java
package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }
}
```

* CartController.java

```java
package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private Cart cart;

    @GetMapping("/add-to-cart")
    @ResponseBody
    public String addToCart(@RequestParam String item) {
        cart.addItem(item);
        return "Added item to cart: " + item;
    }

    @GetMapping("/view-carts")
    @ResponseBody
    public String viewCart(HttpSession httpSession) {
        List<String> items = cart.getItems();
        return "Cart items: " + items;
    }
}
```

* SessionApplication.java

```java
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SessionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionApplication.class, args);
	}

}
```
### Session Working

1. `AppConfig.java`: This class is annotated with `@Configuration` and defines a Spring bean named `cart`. The `cart` bean is configured with a session scope using `@SessionScope`. This means that a single instance of the `Cart` class will be created and associated with each user session.

2. `Cart.java`: This class represents a shopping cart and contains a list of items. Users can add items to the cart using the `addItem` method and retrieve the cart's contents using the `getItems` method.

3. `CartController.java`: This is a Spring `@Controller` class responsible for handling HTTP requests related to the shopping cart. It has a field `cart` that is annotated with `@Autowired`, which means it will be automatically injected with the session-scoped `Cart` bean.

   - The `addToCart` method is mapped to the `/add-to-cart` endpoint and allows users to add items to their shopping cart. It updates the session-scoped `Cart` bean.
   
   - The `viewCart` method is mapped to the `/view-carts` endpoint and allows users to view the contents of their shopping cart. It retrieves the items from the session-scoped `Cart` bean.

4. `SessionApplication.java`: This is the main class of the Spring Boot application. It's annotated with `@SpringBootApplication`, indicating that this is a Spring Boot application.

Here's a brief overview of the application's flow:

1. The Spring Boot application starts, and the `Cart` bean is configured with session scope.

2. Users can make HTTP requests to the `/add-to-cart` endpoint to add items to their shopping cart. The items are stored in the session-scoped `Cart` bean, which is unique to each user's session.

3. Users can also make HTTP requests to the `/view-carts` endpoint to view the contents of their shopping cart. The `CartController` retrieves the items from the session-scoped `Cart` bean and returns them in the response.


