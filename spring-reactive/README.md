# Create a simple Spring Reactive application

**Step 1**: Set up your project

You can use Spring Initializr to quickly generate a Spring Reactive project. Visit [spring.io](https://start.spring.io/) and configure your project as follows:

* Project: Maven Project

* Language: Java

* Spring Boot: (Choose the latest version)

* Group: com.springreactive

* Artifact: springreactive

* Dependencies: Spring reactive web

* Click "Generate" to download the project zip file.

## Import the project into your IDE

**Step 2**:

* Unzip the downloaded file and import the project into your favorite Java IDE (e.g., IntelliJ, Eclipse, or VS Code) as a Maven project.

* Open STS

* Click on file

* Click on import > select maven > select existing maven project > click next

* Browser the unzipped file

* pom.xml file will appear, select it and click on finish

# workflow of mono and flux using test cases

* go to com.reactive package in test folder

* create a class MonoFluxTest

* lets create a method monoTest() to test the workflow of mono

```java

package com.reactive;

public void monoTest() {
    Mono<String> mono = Mono.just("Spring reactive").log();
    mono.subscribe(System.out::println);
}

```

**Output**

```java
12:52:13.111 [main] INFO reactor.Mono.Just.1 -- | onSubscribe([Synchronous Fuseable] Operators.ScalarSubscription)
12:52:13.119 [main] INFO reactor.Mono.Just.1 -- | request(unbounded)
12:52:13.119 [main] INFO reactor.Mono.Just.1 -- | onNext(Spring reactive)
Spring reactive
12:52:13.120 [main] INFO reactor.Mono.Just.1 -- | onComplete()
```

* lets create a method fluxTest() to test the workflow of flux

```java

package com.reactive;

public void fluxTest() {
    Flux<String> flux = Flux.just("Spring", "Spring Boot", "Spring reactive").log();
    flux.subscribe(System.out::println);
}

```

**Output**

```java
13:00:48.320 [main] INFO reactor.Flux.Array.1 -- | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
13:00:48.329 [main] INFO reactor.Flux.Array.1 -- | request(unbounded)
13:00:48.330 [main] INFO reactor.Flux.Array.1 -- | onNext(Spring)
Spring
13:00:48.330 [main] INFO reactor.Flux.Array.1 -- | onNext(Spring Boot)
Spring Boot
13:00:48.330 [main] INFO reactor.Flux.Array.1 -- | onNext(Spring reactive)
Spring reactive
13:00:48.331 [main] INFO reactor.Flux.Array.1 -- | onComplete()
```

* if we want sent the data in middle of the workflow we can use the method onNext() and onComplete() to complete the workflow

```java

package com.reactive;

public void fluxTest() {
    Flux<String> flux = Flux.just("Spring", "Spring Boot", "Spring reactive").concatWithValues("Spring Cloud")
    .concatWith(Flux.error(new RuntimeException("Exception Occurred"))).log();
    flux.subscribe(System.out::println, (e) -> System.err.println(e.getMessage()));
}

```

**Output**

```java
13:04:49.737 [main] INFO reactor.Flux.ConcatArray.1 -- onSubscribe(FluxConcatArray.ConcatArraySubscriber)
13:04:49.745 [main] INFO reactor.Flux.ConcatArray.1 -- request(unbounded)
13:04:49.745 [main] INFO reactor.Flux.ConcatArray.1 -- onNext(Spring)
Spring
13:04:49.745 [main] INFO reactor.Flux.ConcatArray.1 -- onNext(Spring Boot)
Spring Boot
13:04:49.746 [main] INFO reactor.Flux.ConcatArray.1 -- onNext(Spring reactive)
Spring reactive
13:04:49.747 [main] INFO reactor.Flux.ConcatArray.1 -- onNext(Spring Cloud)
Spring Cloud
13:04:49.748 [main] ERROR reactor.Flux.ConcatArray.1 -- onError(java.lang.RuntimeException: Exception Occurred)
13:04:49.748 [main] ERROR reactor.Flux.ConcatArray.1 -- 
java.lang.RuntimeException: Exception Occurred
	at com.reactive.monoFluxTest.fluxTest(monoFluxTest.java:25)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:727)
	at org.junit.jupiter.engine.execution.MethodInvocation.proceed(MethodInvocation.java:60)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$ValidatingInvocation.proceed(InvocationInterceptorChain.java:131)
	at org.junit.jupiter.engine.extension.TimeoutExtension.intercept(TimeoutExtension.java:156)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestableMethod(TimeoutExtension.java:147)
	at org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestMethod(TimeoutExtension.java:86)
	at org.junit.jupiter.engine.execution.InterceptingExecutableInvoker$ReflectiveInterceptorCall.lambda$ofVoidMethod$0(InterceptingExecutableInvoker.java:103)
	at org.junit.jupiter.engine.execution.InterceptingExecutableInvoker.lambda$invoke$0(InterceptingExecutableInvoker.java:93)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain$InterceptedInvocation.proceed(InvocationInterceptorChain.java:106)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.proceed(InvocationInterceptorChain.java:64)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.chainAndInvoke(InvocationInterceptorChain.java:45)
	at org.junit.jupiter.engine.execution.InvocationInterceptorChain.invoke(InvocationInterceptorChain.java:37)
	at org.junit.jupiter.engine.execution.InterceptingExecutableInvoker.invoke(InterceptingExecutableInvoker.java:92)
	at org.junit.jupiter.engine.execution.InterceptingExecutableInvoker.invoke(InterceptingExecutableInvoker.java:86)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$7(TestMethodTestDescriptor.java:217)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:213)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:138)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:68)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:151)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:35)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:54)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:147)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:127)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:90)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:55)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:102)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:54)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:114)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:95)
	at org.junit.platform.launcher.core.DefaultLauncherSession$DelegatingLauncher.execute(DefaultLauncherSession.java:91)
	at org.junit.platform.launcher.core.SessionPerRequestLauncher.execute(SessionPerRequestLauncher.java:60)
	at org.eclipse.jdt.internal.junit5.runner.JUnit5TestReference.run(JUnit5TestReference.java:98)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:40)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:529)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:756)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:452)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)
Exception Occurred
```

# FLux and Mono

* **Flux**


* Create a package com.reactive.model

* Create a class todo

```java
public class Todo  {
	
	
	private int id;
	private String title;
	private String description;
	public Todo(String title, String description) {
		super();
		
		this.title = title;
		this.description = description;
	}
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Todo(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
```

## Create a Todo Dao class

* Create a package com.reactive.repository

* Create a class TodoDao


```java

@Component
public class TodoDao {
	public Flux<Todo> getTodosStream(){
        return Flux.range(1, 5)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count : " + i))
                .map(i -> new Todo(i, "Todo " + i, "Desc " + i));

    }
	}

```

## Create a Service class

* Create a package com.reactive.service

* Create a class TodoService

```java


@Service
public class TodoService {
	
	@Autowired
    private TodoDao todoDao;

	  public Flux<Todo> loadAllTodosStream()
	  {
	    long startTime = System.currentTimeMillis();
	    Flux<Todo> todoFlux = todoDao.getTodosStream();
	    long endTime = System.currentTimeMillis();
	    System.out.println("Total time taken : " + (endTime - startTime));
	    return todoFlux;
	  }

}
```

## Create a TodoController

* Create a package com.reactive.controller

* Create a class TodoController

```java

@RestController
@RequestMapping("/todo")
public class TodoController {

	@Autowired
	private TodoService service;

	@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Todo> getAllTodosStream() {

		return service.loadAllTodosStream();
	}

}

```

## Output

* Run the application and hit the url http://localhost:8080/todo/stream

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.1.5)[0;39m

[2m2023-10-22T09:48:40.684+05:30[0;39m [32m INFO[0;39m [35m21268[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m Starting SpringreactiveApplication using Java 17 with PID 21268 (E:\c\springreactive\target\classes started by admin in E:\c\springreactive)
[2m2023-10-22T09:48:40.700+05:30[0;39m [32m INFO[0;39m [35m21268[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2023-10-22T09:48:43.895+05:30[0;39m [32m INFO[0;39m [35m21268[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.b.web.embedded.netty.NettyWebServer [0;39m [2m:[0;39m Netty started on port 8080
[2m2023-10-22T09:48:43.911+05:30[0;39m [32m INFO[0;39m [35m21268[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m Started SpringreactiveApplication in 4.36 seconds (process running for 6.193)
Total time taken : 6
Stream completed.
processing count : 1
processing count : 2
processing count : 3
processing count : 4
processing count : 5

```

# Mono

* Create a method getTodoById() in the TodoDao class to get the data by id



```java
public Mono<Todo> getTodoById(int id) {
		// TODO Auto-generated method stub
		return getTodosStream().filter(todo -> todo.getId() == id).next();
			}
```

*  Create a method getTodoById() in the TodoService class to get the data by id


```java
public Mono<Todo> getTodoById(int id) {
        return todoDao.getTodoById(id); // Implement this method in TodoDao
    }
```
* Create a method getTodoById() in the TodoController class to get the data by id

```java
@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Todo> getTodoById(@PathVariable int id) {
        return service.getTodoById(id);
    }
```

## Output

* Run the application and hit the url http://localhost:8080/todo/1

```java
{
  "id": 1,
  "title": "Todo 1",
  "description": "Desc 1"
}
```


# Subscribing to Reactive Streams

* In the controller class we have used the method getAllTodosStream(), make it subscribe to the stream by add the method doOnComplete() to the flux

```java
@GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Todo> getAllTodosStream() {
		Flux<Todo> todoFlux = service.loadAllTodosStream();

		// Subscribe to the Flux and return a Mono to signify completion
		return todoFlux.doOnComplete(() -> System.out.println("Stream completed."));
	}
```

## Output

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.1.5)[0;39m

[2m2023-10-22T09:53:15.897+05:30[0;39m [32m INFO[0;39m [35m15816[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m Starting SpringreactiveApplication using Java 17 with PID 15816 (E:\c\springreactive\target\classes started by admin in E:\c\springreactive)
[2m2023-10-22T09:53:15.902+05:30[0;39m [32m INFO[0;39m [35m15816[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2023-10-22T09:53:19.040+05:30[0;39m [32m INFO[0;39m [35m15816[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.b.web.embedded.netty.NettyWebServer [0;39m [2m:[0;39m Netty started on port 8080
[2m2023-10-22T09:53:19.062+05:30[0;39m [32m INFO[0;39m [35m15816[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m Started SpringreactiveApplication in 3.828 seconds (process running for 5.471)
Total time taken : 2
Stream completed.
processing count : 1
processing count : 2
processing count : 3
processing count : 4
processing count : 5
```

# Transforming reactive sequences with operators

* in service class we have used the method loadAllTodosStream() to get the data from the dao class, we can use the method map() to transform the data

```java

public Flux<Todo> loadAllTodosStream() {
long startTime = System.currentTimeMillis();
Flux<Todo> todoFlux = todoDao.getTodosStream()
      .filter(todo -> todo.getId() % 2 == 0) // Filter todos with even IDs
      .map(todo -> {
          // Transform each todo, e.g., modify the title
          todo.setTitle("Modified: " + todo.getTitle());
          return todo;
      });
long endTime = System.currentTimeMillis();
System.out.println("Total time taken : " + (endTime - startTime));
return todoFlux;
}
```

## Output 

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.1.5)[0;39m

[2m2023-10-22T10:00:36.862+05:30[0;39m [32m INFO[0;39m [35m4940[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m Starting SpringreactiveApplication using Java 17 with PID 4940 (E:\c\springreactive\target\classes started by admin in E:\c\springreactive)
[2m2023-10-22T10:00:36.869+05:30[0;39m [32m INFO[0;39m [35m4940[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2023-10-22T10:00:38.163+05:30[0;39m [32m INFO[0;39m [35m4940[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.b.web.embedded.netty.NettyWebServer [0;39m [2m:[0;39m Netty started on port 8080
[2m2023-10-22T10:00:38.174+05:30[0;39m [32m INFO[0;39m [35m4940[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m Started SpringreactiveApplication in 1.702 seconds (process running for 2.457)
Total time taken : 2
Stream completed.
processing count : 1
processing count : 2
processing count : 3
processing count : 4
processing count : 5
```

# Handling reactive sequences and Elements

* In the service class we have used the method loadAllTodosStream() to get the data from the dao class, we can use the method doOnNext() to perform an action on each element in the stream, 

* we can use the method doOnComplete() to perform an action when the stream completes,

* we can use the method doOnError() to perform an action when an error occurs.


```java
    public Flux<Todo> loadAllTodosStream() {
        long startTime = System.currentTimeMillis();
        Flux<Todo> todoFlux = todoDao.getTodosStream()
                .filter(todo -> todo.getId() % 2 == 0)
                .map(todo -> {
                    todo.setTitle("Modified: " + todo.getTitle());
                    return todo;
                })
                .doOnNext(todo -> {
                    // Perform an action on each element, e.g., logging.
                    System.out.println("Processing todo: " + todo.getId());
                })
                .doOnComplete(() -> {
                    long endTime = System.currentTimeMillis();
                    System.out.println("Total time taken: " + (endTime - startTime));
                    System.out.println("Stream completed.");
                })
                .doOnError(error -> {
                    // Handle errors, e.g., log the error or perform recovery actions.
                    System.err.println("An error occurred: " + error.getMessage());
                });
        return todoFlux;
    }
```

## Output

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.1.5)[0;39m

[2m2023-10-22T10:06:13.136+05:30[0;39m [32m INFO[0;39m [35m11700[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m Starting SpringreactiveApplication using Java 17 with PID 11700 (E:\c\springreactive\target\classes started by admin in E:\c\springreactive)
[2m2023-10-22T10:06:13.141+05:30[0;39m [32m INFO[0;39m [35m11700[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2023-10-22T10:06:14.433+05:30[0;39m [32m INFO[0;39m [35m11700[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.b.web.embedded.netty.NettyWebServer [0;39m [2m:[0;39m Netty started on port 8080
[2m2023-10-22T10:06:14.444+05:30[0;39m [32m INFO[0;39m [35m11700[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m Started SpringreactiveApplication in 1.669 seconds (process running for 2.409)
Stream completed.
processing count : 1
processing count : 2
Processing todo: 2
processing count : 3
processing count : 4
Processing todo: 4
processing count : 5
Total time taken: 5111
Stream completed.
```

# Purely functional web with WebFlux

* Create a package com.reactive.router

* Create a class routerConfig

```java

@Configuration
public class RouterConfig {

	@Autowired
	private TodoHandler handler;
	
	@Bean
    public RouterFunction<ServerResponse> todoRoutes(TodoHandler handler) {
        return RouterFunctions.route()
            .GET("/router/todo",handler::getAllTodosStream).build();
    }
}
```
* Create a package com.reactive.handler

* Create a class TodoHandler

```java
@Component
public class TodoHandler {

	@Autowired
	private TodoDao todoDao;
	
  public Mono<ServerResponse> getAllTodosStream(ServerRequest request) {

	  Flux<Todo> todoList=todoDao.getTodosList();
  return ServerResponse.ok().body(todoList, Todo.class);
  }

```

* go to  package com.reactive.dao

* Add the method getTodosList() to get the data from the list

```java
public Flux<Todo> getTodosList(){
	    return Flux.range(1, 5)
	            .doOnNext(i -> System.out.println("processing count : " + i))
	            .map(i -> new Todo(i, "Todo " + i, "Desc " + i));

	}
	
```

## Output

* Run the application and hit the url http://localhost:8080/router/todo

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
[32m :: Spring Boot :: [39m              [2m (v3.1.5)[0;39m

[2m2023-10-23T04:16:05.841+05:30[0;39m [32m INFO[0;39m [35m19596[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m Starting SpringreactiveApplication using Java 17 with PID 19596 (D:\office projects\Spring-5.x\springboot-2.7.8\spring-reactive\springreactive\target\classes started by admin in D:\office projects\Spring-5.x\springboot-2.7.8\spring-reactive\springreactive)
[2m2023-10-23T04:16:05.845+05:30[0;39m [32m INFO[0;39m [35m19596[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
[2m2023-10-23T04:16:07.167+05:30[0;39m [32m INFO[0;39m [35m19596[0;39m [2m---[0;39m [2m[           main][0;39m [36mo.s.b.web.embedded.netty.NettyWebServer [0;39m [2m:[0;39m Netty started on port 8080
[2m2023-10-23T04:16:07.177+05:30[0;39m [32m INFO[0;39m [35m19596[0;39m [2m---[0;39m [2m[           main][0;39m [36mcom.reactive.SpringreactiveApplication  [0;39m [2m:[0;39m Started SpringreactiveApplication in 1.796 seconds (process running for 2.587)
processing count : 1
processing count : 2
processing count : 3
processing count : 4
processing count : 5
```

# functional endpoints for reactive streams

* Create a another endpoint in the routerConfig class

```java
	@Bean
	public RouterFunction<ServerResponse> todoRoutes(TodoHandler handler) {
		return RouterFunctions.route().GET("/router/todo", handler::getAllTodos)
				.GET("/router/todo/{input}", handler::findTodo)
				.POST("/router/todo", handler::createTodo) // POST route
				.build();
	}
```


* Create a method findTodo() in the TodoHandler class

* Create a method createTodo() in the TodoHandler class

```java
  public Mono<ServerResponse> findTodo(ServerRequest request) {
int todoId=Integer.valueOf(request.pathVariable("input"));
Mono<Todo> todoMono = todoDao.getTodosList().filter(d -> d.getId() == todoId).next();
return ServerResponse.ok().body(todoMono,Todo.class);


  }
  
  public Mono<ServerResponse> createTodo(ServerRequest request) {
	  Mono<Todo> todoMono = request.bodyToMono(Todo.class);

      Mono<String> saveResponse = todoMono.map(a -> a.getId() + ":" + a.getTitle() + ":"+ a.getDescription());
      return ServerResponse.ok().body(saveResponse,String.class);

  
  }  

  ```

## Output

* Run the application and hit the url http://localhost:8080/router/todo/1

```
1:Todo 1:Desc 1
```

* go to postman and hit the url http://localhost:8080/router/todo and select the method POST and select the body as raw and select the type as JSON and add the below data

```json
{
	"id": 6,
	"title": "java",
	"description": "springreactive"
}
```

* click on send button

```java
6:java:springreactive
```

