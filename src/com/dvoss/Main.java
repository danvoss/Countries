package com.dvoss;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        HashMap<String, ArrayList<Country>> map = new HashMap<>();
        ArrayList<Country> countries = new ArrayList<>();
        File f = new File("countries.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Country country = new Country(columns[0], columns[1]);
            countries.add(country);
            for (Country cntry : countries) {
                if (!map.containsKey(String.valueOf(country.name.charAt(0)))) {
                    map.put(String.valueOf(country.name.charAt(0)), new ArrayList<>());
                    }

            }
        }

        System.out.println(countries);

    }
}
