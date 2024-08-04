package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    // create a function that will return a function of type string
    // to create a flux:
    // as an example - we will use the method Flux.fromIterable which will take in a collection and return a flux
    // in reality, the flux would be coming from a db or remote service call

    public Flux<String> namesFlux() {
       return Flux.fromIterable(List.of("Alex", "Ben", "Chloe")).log();
    };

    // Mono.just() will create a mono where you pass in the data
    public Mono<String> nameMono() {
        return Mono.just("Jordan").log();
    }

    // example to just show the map() operator
    public Flux<String> namesFluxMapped() {
        return Flux.fromIterable(List.of("Alex", "Ben", "Chloe")).map( each -> { return each.toUpperCase(); }).log();
    };

    // example to show the filter operator
    public Flux<String> namesFluxFiltered() {
        return Flux.fromIterable(List.of("Alex", "Ben", "Chloe")).filter( each -> each.contains("Al")).log();
    };

    public static void main(String[] args) {

        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

        // how to access these values?
        // only way to access these values is to subscribe to the flux
        // call the class and the function namesFlux - this will return a flux
        // by calling the method .subscribe, you will get access to the elements
        // all the elements in the flux will be sent in the form of stream, one by one

        fluxAndMonoGeneratorService.namesFlux()
            .subscribe(name -> {
                System.out.println("Flux name is " + name);
        });
        fluxAndMonoGeneratorService.nameMono()
            .subscribe(name -> {
                System.out.println("Mono name is " + name);
        });
        fluxAndMonoGeneratorService.namesFluxMapped()
            .subscribe(name -> {
        System.out.println("Mapped name is " + name);
        });
        fluxAndMonoGeneratorService.namesFluxFiltered()
            .subscribe(name -> {
                System.out.println("Filtered name is " + name);
        });

    }

}
