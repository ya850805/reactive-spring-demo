package com.demo.s02;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.stream.Stream;

public class C01ReactorAPIs {

    private static void createFluxFromExistingData() {
        var justFlux = Flux.just(1, 2, 3, 4, 5, 6);
        subscribeFlux("justFlux", justFlux);

        var arrayFlux = Flux.fromArray(new Integer[]{1, 2, 3, 4, 5, 6});
        subscribeFlux("arrayFlux", arrayFlux);

        var iterableFlux = Flux.fromIterable(Arrays.asList(1, 2, 3, 4, 5, 6));
        subscribeFlux("iterableFlux", iterableFlux);

        var streamFlux = Flux.fromStream(Stream.of(1, 2, 3, 4, 5, 6));
        subscribeFlux("streamFlux", streamFlux);

        var rangeFlux = Flux.range(1, 6);
        subscribeFlux("rangeFlux", rangeFlux);
    }

    private static void createFluxProgrammatically() {
        var generateFlux = Flux.generate(() -> 1, (state, sink) -> {
            sink.next("message #" + state);
            if(state == 10) {
                sink.complete();
            }
            return state + 1;
        });

        subscribeFlux("generateFlux", generateFlux);
    }

    private static void subscribeFlux(String varName, Flux<?> flux) {
        flux.doOnSubscribe(s -> System.out.print(varName + ": "))
                .doOnNext(e -> System.out.print(e + ", "))
                .doOnComplete(System.out::println)
                .subscribe();
    }

    public static void main(String[] args) {
        createFluxFromExistingData();
        createFluxProgrammatically();
    }
}
