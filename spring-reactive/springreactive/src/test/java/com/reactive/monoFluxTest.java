package com.reactive;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class monoFluxTest {

//@Test
//public void monoTest() {
//    Mono<String> mono = Mono.just("Spring reactive").log();
//    mono.subscribe(System.out::println);
//}

//public void fluxTest() {
//    Flux<String> flux = Flux.just("Spring", "Spring Boot", "Spring reactive").log();
//    flux.subscribe(System.out::println);
//}


@Test
public void fluxTest() {
    Flux<String> flux = Flux.just("Spring", "Spring Boot", "Spring reactive").concatWithValues("Spring Cloud")
    .concatWith(Flux.error(new RuntimeException("Exception Occurred"))).log();
    flux.subscribe(System.out::println, (e) -> System.err.println(e.getMessage()));
}

}
	
