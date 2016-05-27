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

        ArrayList<Country> testCountriesB = map.get("b");
        Country testCountryB = testCountriesB.get(0);
        assertTrue(testCountryB.name.equals("bahamas"));

        ArrayList<Country> testCountriesC = map.get("c");
        Country testCountryC = testCountriesC.get(0);
        assertTrue(testCountryC.name.equals("cambodia"));
    }
}