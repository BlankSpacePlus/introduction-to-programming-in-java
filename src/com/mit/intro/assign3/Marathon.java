package com.mit.intro.assign3;

public class Marathon {

    public static void main(String[] arguments) {
        String[] names = {
                "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt", "Alex",
                "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda",
                "Aaron", "Kate"
        };
        int[] times = {
                341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393, 299,
                343, 317, 265
        };
        int minIndex, secondMinIndex;
        if (times[0] <= times[1]) {
            minIndex = 0;
            secondMinIndex = 1;
        } else {
            minIndex = 1;
            secondMinIndex = 0;
        }
        for (int i = 2; i < names.length; i++) {
            if (times[i] < times[minIndex]) {
                secondMinIndex = minIndex;
                minIndex = i;
            } else if (times[i] < times[secondMinIndex]) {
                secondMinIndex = i;
            }
        }
        System.out.println("The fastest runner is " + names[minIndex] + ", he/she uses " + times[minIndex] + " minutes.");
        System.out.println("The second fastest runner is " + names[secondMinIndex] + ", he/she uses " + times[secondMinIndex] + " minutes.");
    }

}
