package com.dvoss;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Dan on 5/27/16.
 */
public class MainTest {
    @Test
    public void parseCountries() throws Exception {
        HashMap<String, ArrayList<Country>> map = Main.parseCountries("test.txt");

        ArrayList<Country> testCountries = map.get("a");
        Country testCountry = testCountries.get(0);
        assertTrue(testCountry.name.equals("afghanistan"));


        //System.out.println(map.get("a"));

//        assertTrue(map.get("a").equals("afghanistan"));
//        assertTrue(map.get("b").equals("bahamas"));
//        assertTrue(map.get("c").equals("cambodia"));
    }

    @Test
    public void readInputWriteFile() throws Exception {
        HashMap<String, ArrayList<Country>> map = new HashMap<>();
        Main.readInputWriteFile(map);
        //assertTrue();

    }
}