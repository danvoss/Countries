package com.dvoss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        HashMap<String, ArrayList<Country>> map = new HashMap<>();
        File f = new File("countries.txt");
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
        //System.out.println(map);

        System.out.println("Type a letter to save a list of countries starting with that letter.");
        Scanner scanner = new Scanner(System.in);
        // if not a single letter, throw exception
        String letter = scanner.nextLine();
        File c = new File("&s_countries.txt\n", letter);
        FileWriter fw = new FileWriter(c);
        //fw.write();

    }
}
