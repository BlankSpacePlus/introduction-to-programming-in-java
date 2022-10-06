package com.mit.intro.assign1;

public class GravityCalculator {

    public static void main(String[] arguments) {
        double gravity = -9.81;
        double initialVelocity = 0.0;
        double fallingTime = 10.0;
        double initialPosition = 0.0;
        double finalPosition = 0.0;
        finalPosition = 0.5 * gravity * fallingTime * fallingTime + initialVelocity * fallingTime + initialPosition;
        System.out.printf("The object's position after %.0f seconds is %.1f m.", fallingTime, finalPosition);
    }

}
