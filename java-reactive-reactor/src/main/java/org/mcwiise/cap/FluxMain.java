package org.mcwiise.cap;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class FluxMain {

    public static void main(String[] args) {
        FluxMain.emitAndSubscribe();
    }

    public static void emitAndSubscribe(){
        var flux = Flux.fromArray(new String[]{"A", "B", "C"});
        flux.subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed!")
        );
    }
}
