# Create a simple constructor and setter DI

* Step 1: Open STS: Launch STS by clicking on the application icon.

* Step 2: Create a New Maven Project: To create a new Maven project, go to `File > New > Other...` 

* Step 3: Select Maven Project: In the "Select a wizard" dialog, expand the "Maven" category and choose "Maven Project." Click "Next."

* Step 4: Select Project Location: In the `Select a wizard` dialog, select the checkbox for `Use defalut workspace location` Click "Next."

* Step 5: Select catalog as `internal` and select fliter > `org.apache.maven.archetypes maven archetype quickstart 1.1`

**Configure the Project**:

- Group ID and Artifact ID: Enter values for the Group ID and Artifact ID. These identify your project and are used in naming conventions.
- Package: Enter the package name for your project.
- Version: Specify the project version.
- Click "Finish".

## Constructor based DI Code Explanation

* The `Employee` class has a single constructor that takes a `String` parameter. The `user` field is set with the value provided during object construction.

* The `Technology` class also has a single constructor that takes an `Employee` object as a parameter. The `Employee` object is assigned to the `employee` field. The `start` method uses the `employee` field to access the user's information.

* In the Spring configuration XML, you define two beans: `employee` and `technology`. The `<constructor-arg>` elements specify how the constructor-based injection should be done.
```xml
   <bean id="employee" class="com.example.cons.Employee">
       <constructor-arg value="spring-boot" />
   </bean>

   <bean id="technology" class="com.example.cons.Technology">
       <constructor-arg ref="employee" />
   </bean>
   ```
* For the `employee` bean, you provide a literal value "spring-boot" as an argument to its constructor.
* For the `technology` bean, you provide a reference to the `employee` bean as an argument to its constructor. This is where the actual dependency injection occurs.

* In the `main` method, you initialize the Spring container and retrieve the `Technology` bean. Spring, based on the configuration, automatically injects the `Employee` object into the `Technology` object's constructor during bean creation.

* This is the essence of constructor-based Dependency Injection in Spring. It promotes loose coupling between components, makes it easier to test and change dependencies, and improves the maintainability and scalability of your application.


### Configure the POM.Xml by adding the following dependencies:

```xml
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>5.1.9.RELEASE</version>
		</dependency>

```
### Create a java class in the package 

* Right click on the package > `select the new` > `click on class`

* **App.java**

```java
package com.example.cons;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Technology technology = context.getBean("technology", Technology.class);

        technology.start();
    }
}
```

* **Employee.java** 

```java
package com.example.cons;

public class Employee {
    private String User;
    public Employee(String User) {
        this.User = User;
    }
	public String getUser() {
		return User;
	}
}
```

* **Technology.java**

```java
package com.example.cons;

public class Technology {
    private Employee employee;

    public Technology(Employee employee) {
        this.employee = employee;
    }

    public void start() {
        System.out.println("employee is  good at  " + employee.getUser() );
    }
}
```

### Configure Xml File

* Right click on the package > `select the new` > `click on other` > `select xml file`

* Spring.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define the beans with constructor-based injection -->
    <bean id="employee" class="com.example.cons.Employee">
        <constructor-arg value="spring-boot" />
    </bean>

    <bean id="technology" class="com.example.cons.Technology">
        <constructor-arg ref="employee" />
    </bean>
</beans>
```

* Run the `App.java`

* **Output**: 

```java
Employee is good at spring-boot
```


## Setter based DI Code Explanation

* In the `Employee` class, there is a `User` property with a corresponding setter method. The setter method, `setUser(String user)`, is used to set the value of the `User` property.

* The `Technology` class also contains a setter method, `setEmployee(Employee employee)`, which is used to inject an `Employee` object into the `Technology` class.

* In the Spring configuration XML, you define two beans: `employee` and `technology`. For the `employee` bean, you use the `<property>` element to set the value of the `user` property. For the `technology` bean, you use the `<property>` element to inject the `employee` bean as a dependency using the `setEmployee` method.
```xml
   <bean id="employee" class="com.example.setter.Employee">
       <property name="user" value="spring-MVC" />
   </bean>

   <bean id="technology" class="com.example.setter.Technology">
       <property name="employee" ref="employee" />
       <!-- Other property configurations if any -->
   </bean>
   ```
* In the `main` method, you initialize the Spring container, retrieve the `Technology` bean, and call the `start` method. The dependency injection is automatically handled by Spring based on the configuration.

When you run this application, it will output:


This output is generated by the `System.out.println` statement inside the `start` method of the `Technology` class, which displays "Employee is good at" followed by the value of the `user` property of the injected `Employee` object, which is "spring-MVC" in this case.

### Add the dependency in POM.xml

```xml

  		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>5.1.9.RELEASE</version>
		</dependency>

```
### Create a java class in the package 

* Right click on the package > `select the new` > `click on class`

* **App.java**

```java
package com.example.setter;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        // Initialize the Spring container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Technology technology = (Technology) context.getBean("technology");

        technology.start();
    }
}
```

* **Employee.java** 

```java
package com.example.setter;


public class Employee {
    private String User;

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}
      
 }
```

* **Technology.java**

```java
package com.example.setter;


public class Technology {
    private Employee employee;


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public void start() {
        System.out.println("employee is  good at  " + employee.getUser() );
    }
}
```

### Configure Xml File

* Right click on the package > `select the new` > `click on other` > `select xml file`

* Spring.xml

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="employee" class="com.example.setter.Employee">
        <property name="user" value="spring-MVC" />
    </bean>

    
    <bean id="technology" class="com.example.setter.Technology">
    <property name="employee" ref="employee" />
    <!-- Other property configurations if any -->
</bean>
</beans>
```

* Run the `App.java`

* **Output**:

```java
Employee is good at spring-MVC
```
