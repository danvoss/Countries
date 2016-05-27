package com.dvoss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    // parseCountries method

    public static HashMap<String, ArrayList<Country>> parseCountries(String filename) throws FileNotFoundException {
        HashMap<String, ArrayList<Country>> map = new HashMap<>();
        File f = new File(filename);
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            if (!map.containsKey(String.valueOf(country.name.charAt(0)))) {
                map.put(String.valueOf(country.name.charAt(0)), new ArrayList<>());
            }
            ArrayList<Country> countries = map.get(String.valueOf(country.name.charAt(0)));
            countries.add(country);
        }
        return map;
    }

    //readInputWriteFile method

    public static void readInputWriteFile(HashMap<String, ArrayList<Country>> map) throws Exception {
        System.out.println("Type a letter to save a list of countries starting with that letter.");
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine();
        if (letter.length() != 1) {
            throw new Exception("Please type a single letter.");
        } else {
            File c = new File(letter + "_countries.txt");
            FileWriter fw = new FileWriter(c);
            ArrayList<Country> list = map.get(letter);
            fw.write(list.toString());
            fw.close();
        }
    }

    public static void main(String[] args) throws Exception {

        HashMap<String, ArrayList<Country>> map = parseCountries("countries.txt");

        readInputWriteFile(map);

//        HashMap<String, ArrayList<Country>> map = new HashMap<>();
//        File f = new File("countries.txt");
//        Scanner fileScanner = new Scanner(f);
//        while (fileScanner.hasNext()) {
//            String line = fileScanner.nextLine();
//            String[] columns = line.split("\\|");
//            Country country = new Country(columns[0], columns[1]);
//                if (!map.containsKey(String.valueOf(country.name.charAt(0)))) {
//                    map.put(String.valueOf(country.name.charAt(0)), new ArrayList<>());
//                }
//                ArrayList<Country> countries = map.get(String.valueOf(country.name.charAt(0)));
//                countries.add(country);
//        }
        //System.out.println(map);

//        System.out.println("Type a letter to save a list of countries starting with that letter.");
//        Scanner scanner = new Scanner(System.in);
//        String letter = scanner.nextLine();
//        if (letter.length() != 1) {
//            throw new Exception("Please type a single letter.");
//        }
//        else {
//            File c = new File(letter + "_countries.txt");
//            FileWriter fw = new FileWriter(c);
//            ArrayList<Country> list = map.get(letter);
//            fw.write(list.toString());
//            fw.close();
//        }
//        //System.out.println(map.get(letter));
//    }
    }
}
