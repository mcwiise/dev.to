package org.mcwiise.cap;

import reactor.core.publisher.Mono;

public class MonoMain {
    public static void main(String[] args) {
        MonoMain.emitAndSubscribe();
    }

    public static void emitAndSubscribe(){
        var mono = Mono.just("A");
        mono.subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed!")
        );
    }

}