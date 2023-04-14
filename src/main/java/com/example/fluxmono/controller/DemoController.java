package com.example.fluxmono.controller;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.stream.Stream;

@RestController
public class DemoController {
    @GetMapping(value = "/demo")
    public Publisher<Integer> demo(){
        //Publisher is as the same Mono and Flux.
        //Publisher is called Mono and Flux.
//        return Flux.fromStream(
//                Stream.of(1, 2, 3, 4, 5, 6 ,7, 8, 9)
//        ).delayElements(Duration.ofSeconds(4));

        return Mono.just(9).delayElement(Duration.ofSeconds(3)); // Mono phyit lo Mono.just(8) data one lone pae ya tal.
    }
}
