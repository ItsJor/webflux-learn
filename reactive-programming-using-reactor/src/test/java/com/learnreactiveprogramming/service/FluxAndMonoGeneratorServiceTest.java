package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

class FluxAndMonoGeneratorServiceTest {

    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void namesFlux() {

        // grab the flux from the service namesFlux method
        var namesFlux = fluxAndMonoGeneratorService.namesFlux();

        // Use the reactor.test method StepVerifier
        // use the create method and pass in the flux
        // use expectNext to expect the elements - expect these elements once the subscription is invoked
        // after that, we want to verify the completion signal - .verifyComplete()
        StepVerifier.create(namesFlux)
                .expectNext("Alex", "Ben", "Chloe")
                .verifyComplete();
    }

    @Test
    void checkNamesFluxCount() {
        var namesFlux = fluxAndMonoGeneratorService.namesFlux();
        StepVerifier.create(namesFlux)
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void checkNamesUpperCase() {
        var namesFlux = fluxAndMonoGeneratorService.namesFluxMapped();
        StepVerifier.create(namesFlux)
                .expectNext("ALEX", "BEN", "CHLOE")
                .verifyComplete();
    }

    @Test
    void checkNamesFiltered() {
        var namesFlux = fluxAndMonoGeneratorService.namesFluxFiltered();
        StepVerifier.create(namesFlux)
                .expectNextCount(1)
                .verifyComplete();
    }

}