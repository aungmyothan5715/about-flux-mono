package com.example.fluxmono.controller;

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
        f1.doOnNext(c -> {throw new RuntimeException("Noooooooooooo");})
                //this is ok you write in doOnNext()
                .subscribe(new Subscriber<Integer>() {
            private Subscription s;
            //if you create object new Subscriber<Integer>() in subscribe() method.It is being anonymous inner class.
            // auto generate override method
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("Subscription");
                this.s = s;
                s.request(1); // if you want to request number is two s.request(2).
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext:: " + integer);
                s.request(1);

                //if you want to show all elements of f1
                //first -> private Subscription s;
                //second -> s.request(1) in noNext() method.
                // dr p: bl go lo lan hyon fo use.

                //if occur error show error.
                //if(integer == 3) throw new RuntimeException("No, I can't work!");
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Throwable:: " + t);

                //In this part,if occur error show error.

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete::");

            }
        });
    }


}
