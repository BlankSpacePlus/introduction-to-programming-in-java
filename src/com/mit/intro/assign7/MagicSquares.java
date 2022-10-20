package com.mit.intro.assign7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MagicSquares {

    public static boolean testMagic(String pathName) throws IOException {
        // Open the file
        BufferedReader reader = new BufferedReader(new FileReader(pathName));
        boolean isMagic = true;
        int lastSum = -1;
        // For each line in the file ...
        String line;
        int[][] nums = null;
        int lineCount = 0;
        while ((line = reader.readLine()) != null) {
            // ... sum each row of numbers
            if ("".equals(line)) {
                continue;
            }
            String[] parts = line.split("\\s+");
            int partLength = parts.length;
            if (nums == null) {
                nums = new int[partLength][partLength];
            }
            int rowSum = 0;
            for (int j = 0; j < partLength; j++) {
                nums[lineCount][j] = Integer.parseInt(parts[j]);
                rowSum += nums[lineCount][j];
            }
            if (lastSum == -1) {
                // If this is the first row, remember the sum
                lastSum = rowSum;
            } else if (lastSum != rowSum) {
                // if the sums don't match, it isn't magic, so stop reading
                isMagic = false;
                break;
            }
            lineCount++;
        }
        reader.close();
        if (nums != null) {
            int colSum = 0;
            for (int j = 0; j < nums.length; j++) {
                for (int i = 0; i < nums.length; i++) {
                    colSum += nums[i][j];
                }
                if (lastSum != colSum) {
                    isMagic = false;
                    break;
                }
                colSum = 0;
            }
            int diagSum = 0;
            int backDiagSum = 0;
            for (int i = 0; i < nums.length; i++) {
                diagSum += nums[i][i];
                backDiagSum += nums[i][nums.length-i-1];
            }
            if (lastSum != diagSum || lastSum != backDiagSum) {
                isMagic = false;
            }
        }
        return isMagic;
    }

    public static void main(String[] args) throws IOException {
        String[] fileNames = {"src/com/mit/intro/assign7/Mercury.txt", "src/com/mit/intro/assign7/Luna.txt"};
        for (String fileName : fileNames) {
            System.out.println(fileName + " is magic? " + testMagic(fileName));
        }
    }

}
