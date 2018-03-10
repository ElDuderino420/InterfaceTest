package com.company;

import org.hamcrest.BaseMatcher;
import org.hamcrest.CoreMatchers;
import org.hamcrest.collection.IsArrayContaining;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.BaseMatcher.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;

public class HamcrestTest {

    @Test
    public void firstTest() throws AlreadyExistsException {
        ICarCollection testSubject = new CarCollection();
        Collection<ICar> testcol = testSubject.addCar("ED12345", "VW", "Polo", 2001, "Red");

        assertThat(testcol.toArray(), arrayContaining(samePropertyValuesAs(new Car("ED12345", "VW", "Polo", 2001, "Red"))));

    }

    @Test
    public void lastTest() {

        List<ICar> testlist = Arrays.asList(
                new Car("ED12345", "VW", "Polo", 2001, "Red"),
                new Car("AB35728", "Toyota", "Corolla", 2002, "Green"),
                new Car("ZZ50123", "Audi", "A4 Avant", 1999, "Black"));
        ICarCollection testSubject = new CarCollection(testlist);

        assertThat(testSubject.getAllCars(), containsInAnyOrder(testlist.get(0), testlist.get(1), testlist.get(2)));


    }
}