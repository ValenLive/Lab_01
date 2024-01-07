package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utility {
    public static List<Ship> createShipsFromFile(String filePath) {
        List<Ship> shipList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(filePath));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");

                if (values.length == 3) {
                    double tonnage = Double.parseDouble(values[0]);
                    String name = values[1];
                    int passengerCount = Integer.parseInt(values[2]);

                    shipList.add(new Ship(tonnage, name, passengerCount));
                } else {
                    System.out.println("Invalid data format in the file. Skipping line.");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
        return shipList;
    }



    public static List<Ship> insertionSortByTonnage(List<Ship> shipList, boolean printDetails) {
        int n = shipList.size();
        List<Ship> sortedList = new ArrayList<>(shipList);

        long startTime = System.currentTimeMillis();
        int comparisonCount = 0;
        int exchangeCount = 0;

        for (int i = 1; i < n; ++i) {
            Ship key = sortedList.get(i);
            int j = i - 1;

            while (j >= 0 && sortedList.get(j).getTonnage() > key.getTonnage()) {
                sortedList.set(j + 1, sortedList.get(j));
                j = j - 1;

                comparisonCount++;
                exchangeCount++;
            }
            sortedList.set(j + 1, key);
            exchangeCount++;
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        if (printDetails) {
            System.out.println("Insertion Sort Details:");
            System.out.println("Execution Time: " + executionTime + " milliseconds");
            System.out.println("Comparison Count: " + comparisonCount);
            System.out.println("Exchange Count: " + exchangeCount);
        }

        return sortedList;
    }


    public static List<Ship> mergeSortByPassengerCountDescending(List<Ship> shipList, boolean printDetails) {
        long startTime = System.currentTimeMillis();

        int[] comparisonCount = {0}; // Using an array to store value by reference
        List<Ship> sortedList = mergeSortByPassengerCountDescendingHelper(shipList, comparisonCount);

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        if (printDetails) {
            System.out.println("Merge Sort Details:");
            System.out.println("Execution Time: " + executionTime + " milliseconds");
            System.out.println("Comparison Count: " + comparisonCount[0]);
            // Since Merge Sort doesn't involve exchanges, set Exchange Count to 0
            System.out.println("Exchange Count: Merge Sort doesn't involve exchanges");
        }

        return sortedList;
    }

    private static List<Ship> mergeSortByPassengerCountDescendingHelper(List<Ship> shipList, int[] comparisonCount) {
        if (shipList.size() <= 1) {
            return shipList;
        }

        int mid = shipList.size() / 2;
        List<Ship> leftHalf = shipList.subList(0, mid);
        List<Ship> rightHalf = shipList.subList(mid, shipList.size());

        // Recursive calls for left and right halves
        leftHalf = mergeSortByPassengerCountDescendingHelper(leftHalf, comparisonCount);
        rightHalf = mergeSortByPassengerCountDescendingHelper(rightHalf, comparisonCount);

        // Merge the sorted halves
        return merge(leftHalf, rightHalf, comparisonCount);
    }

    private static List<Ship> merge(List<Ship> left, List<Ship> right, int[] comparisonCount) {
        List<Ship> result = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            // Count the comparison operation
            comparisonCount[0]++;

            if (left.get(leftIndex).getNumberOfPassengers() > right.get(rightIndex).getNumberOfPassengers()) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        // Copy the remaining elements from left and right sublists (if any)
        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }
}
