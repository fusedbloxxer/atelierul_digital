package com.company;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Main {

    public static void main(String[] args) {

        SubmissionPublisher<Integer> sp = new SubmissionPublisher<>();
        sp.subscribe(new Flow.Subscriber<Integer>() {
            int numberOfConsumedItems = 0;
            private Flow.Subscription subscription;
            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                System.out.println("I just subscribed!");
                subscription.request(1);
            }

            @Override
            public void onNext(Integer item) {
                System.out.println("I got this!" + item);

            }

            @Override
            public void onError(Throwable throwable) {
                this.numberOfConsumedItems++;
                System.err.println("OOPS");
            }

            @Override
            public void onComplete() {
                System.out.println("COMPLETED");
            }
        });

        sp.submit(1);
        sp.submit(2);
        sp.submit(3);
    }
}
