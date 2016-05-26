package com.dvoss;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

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
    }
}
