package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Ship> ships = Utility.createShipsFromFile("C:\\Users\\Valentyn\\Documents\\University\\ProgrammingAlgorithms_P1\\LABS\\Lab-01\\src\\main\\resources\\ship_data.txt");
        System.out.println("Ship list: ");
        ships.forEach(System.out::println);

        System.out.println("-------------------------");
        List<Ship> insertionSortedShips = Utility.insertionSortByTonnage(ships, true);
        insertionSortedShips.forEach(System.out::println);

        System.out.println("-------------------------");
        List<Ship> mergeSortedShips = Utility.mergeSortByPassengerCountDescending(ships, true);
        mergeSortedShips.forEach(System.out::println);
    }
}