package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Ask user to choose a language and then print in the selected language
 * the following 5 words/expressions :
 *
 * Hello - Good Bye - Thank you - Please - I love you
 *
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String pathName = ""; // Will contain the right path to the right file

        System.out.println("Please choose a language :\n");
        System.out.println("1 - English");
        System.out.println("2 - French");
        System.out.println("3 - Afrikaans");
        System.out.println("4 - Hindi");
        System.out.println("5 - Bengali");
        System.out.println("\n -------------------------");

        System.out.print("->");

        int userChoice;
        try {
            userChoice = scanner.nextInt();
        } catch (Exception e) {
            throw new IllegalArgumentException("We expected an Integer.");
        }

        switch (userChoice) {
            case 1 :
                pathName = "assets/english.txt";
                break;
            case 2 :
                pathName = "assets/french.txt";
                break;
            case 4 :
                pathName = "assets/hindi.txt";
                break;
            case 5:
                pathName = "assets/hindi.txt";
                break;
            default:
                break;
        }


        List<String> original = new ArrayList<>(Arrays.asList(
                "Hello",
                "Good Bye",
                "Thank you",
                "Please",
                "I love you"));

        List<String> translation = new ArrayList<>();
        try {
            translation = getListFromFile(pathName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        printList(original, translation);

    }

    public static void printList(List<String> original, List<String> translation) {

        System.out.println("");

        for (int i = 0; i < original.size(); i ++) {

            System.out.println(original.get(i) + " --> " + translation.get(i));

        }

    }

    public static List<String> getListFromFile(String pathName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(pathName));
        List<String> list = new ArrayList<>();

        while (scan.hasNext()) {
            list.add(scan.nextLine());
        }

        scan.close();
        return list;
    }
}
