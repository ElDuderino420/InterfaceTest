package com.company;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class CarCollectionTest5 {

    private ICarCollection getNewTestSubject()
    {
        ICarCollection col = new CarCollection();
        return col;
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void testAddCar() throws AlreadyExistsException
    {
        ICarCollection testSubject = getNewTestSubject();
        testSubject.addCar("ED12345", "VW", "Polo", 2001, "Red");
        Collection<ICar> allCars = testSubject.getAllCars();
        assertEquals(allCars.size(), 1);
        for(ICar car : allCars)
        {
            assertEquals(car.getRegistrationNumber(), "ED12345");
            assertEquals(car.getBrand(), "VW");
            assertEquals(car.getModel(), "Polo");
            assertEquals(car.getYear(), 2001);
            assertEquals(car.getColor(), "Red");
        }

    }

    @Test
    public void testGetAllCars() throws AlreadyExistsException
    {
        ICarCollection testSubject = getNewTestSubject();
        testSubject.addCar("ZZ50123", "Audi", "A4 Avant", 1999, "Black");
        testSubject.addCar("AB35728", "Toyota", "Corolla", 2002, "Green");
        Collection<ICar> allCars = testSubject.getAllCars();
        assertEquals(allCars.size(), 2);
        Iterator<ICar> it = allCars.iterator();
        assertTrue(it.hasNext());
        ICar a = it.next();
        assertTrue(it.hasNext());
        ICar b = it.next();

        if(a.getRegistrationNumber().equals("AB35728"))
        {
            ICar tmp = a;
            a = b;
            b = tmp;
        }
        assertEquals(a.getRegistrationNumber(), "ZZ50123");
        assertEquals(a.getBrand(), "Audi");
        assertEquals(a.getModel(), "A4 Avant");
        assertEquals(a.getYear(), 1999);
        assertEquals(a.getColor(), "Black");

        assertEquals(b.getRegistrationNumber(), "AB35728");
        assertEquals(b.getBrand(), "Toyota");
        assertEquals(b.getModel(), "Corolla");
        assertEquals(b.getYear(), 2002);
        assertEquals(b.getColor(), "Green");
    }
}