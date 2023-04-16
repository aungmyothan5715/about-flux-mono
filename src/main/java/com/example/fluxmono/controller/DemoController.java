package com.example.fluxmono.controller;

import com.example.fluxmono.subscriber.DemoSubscriber;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
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
    public void demo(){ /*return type void can not work in spring boot.*/
        //for work Publisher<Mono or Flux> instead of demo

        //Publisher is as the same Mono and Flux.
        //Publisher is called Mono and Flux.
//        return Flux.fromStream(
//                Stream.of(1, 2, 3, 4, 5, 6 ,7, 8, 9)
//        ).delayElements(Duration.ofSeconds(4));

        //return Mono.just(9).delayElement(Duration.ofSeconds(3)); // Mono phyit lo Mono.just(8) data one lone pae ya tal.

//        var f1 = Flux.just(1, 2, 3, 4, 5, 6, 7);
//
//                f1.doOnNext(System.out::println).delayElements(Duration.ofSeconds(2));
        var f1 = Flux.just(112, 2, 3, 4, 5, 6, 7, 8 ,9);
        f1//.doOnNext(c -> {throw new RuntimeException("Noooooooooooo");})
                //doOnNext() method
                .subscribe(
                        //new Subscriber<Integer>() {} // No need annonymous inner class because of DemoSubscriber.java
                        new DemoSubscriber()
                );
    }


}
