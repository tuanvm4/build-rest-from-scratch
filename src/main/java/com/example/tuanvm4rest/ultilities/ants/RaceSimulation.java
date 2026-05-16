package com.example.tuanvm4rest.ultilities.ants;

import java.util.concurrent.CountDownLatch;

class RacingCar implements Runnable {
    private final String name;
    private final CountDownLatch readyLatch;
    private final CountDownLatch startLatch;

    public RacingCar(String name,
                     CountDownLatch readyLatch,
                     CountDownLatch startLatch) {
        this.name = name;
        this.readyLatch = readyLatch;
        this.startLatch = startLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " is ready at the starting line.");

            // Notify main thread this car is ready
            readyLatch.countDown();

            // Wait for start signal
            startLatch.await();

            System.out.println(name + " started racing!");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class RaceSimulation {
    public static void main(String[] args) throws InterruptedException {
        int n = 5;

        CountDownLatch readyLatch = new CountDownLatch(n);
        CountDownLatch startLatch = new CountDownLatch(1);

        // Create cars
        for (int i = 1; i <= n; i++) {
            new Thread(
                    new RacingCar("Car-" + i, readyLatch, startLatch)
            ).start();
        }

        // Wait until all cars are ready
        readyLatch.await();

        System.out.println("\nAll cars ready... GO!\n");

        // Race start
        startLatch.countDown();
    }
}