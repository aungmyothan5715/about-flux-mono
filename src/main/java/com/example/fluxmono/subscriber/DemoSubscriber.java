package com.example.fluxmono.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DemoSubscriber implements Subscriber<Integer> {
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
}
