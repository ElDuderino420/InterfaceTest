package com.company;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CarCollectionTest {

    public CarCollectionTest()
    {
    }

    private ICarCollection getNewTestSubject()
    {
        ICarCollection col = new CarCollection();
        return col;
    }

    @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of addCar method, of class ICarCollection.
     */
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

    /**
     * Test of getAllCars method, of class ICarCollection.
     */
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

    /**
     * Test of removeCar method, of class ICarCollection.
     */
    @Test
    public void testRemoveCar() throws AlreadyExistsException
    {
        ICarCollection testSubject = getNewTestSubject();
        testSubject.addCar("ZZ50123", "Audi", "A4 Avant", 1999, "Black");
        testSubject.addCar("AB35728", "Toyota", "Corolla", 2002, "Green");
        testSubject.removeCar("ZZ50123");
        Collection<ICar> allCars = testSubject.getAllCars();
        assertEquals(allCars.size(), 1);
        for(ICar car : allCars)
        {
            assertEquals(car.getRegistrationNumber(), "AB35728");
            assertEquals(car.getBrand(), "Toyota");
            assertEquals(car.getModel(), "Corolla");
            assertEquals(car.getYear(), 2002);
            assertEquals(car.getColor(), "Green");
        }

    }

    /**
     * Test of findFromRegistrationNumber method, of class ICarCollection.
     */
    @Test
    public void testFindFromRegistrationNumber() throws AlreadyExistsException
    {
        ICarCollection testSubject = getNewTestSubject();
        testSubject.addCar("ZZ50123", "Audi", "A4 Avant", 1999, "Black");
        testSubject.addCar("AB35728", "Toyota", "Corolla", 2002, "Green");
        ICar car = testSubject.findFromRegistrationNumber("AB35728");
        assertEquals(car.getRegistrationNumber(), "AB35728");
        assertEquals(car.getBrand(), "Toyota");
        assertEquals(car.getModel(), "Corolla");
        assertEquals(car.getYear(), 2002);
        assertEquals(car.getColor(), "Green");

        car = testSubject.findFromRegistrationNumber("AB35729");
        assertNull(car);
    }

    /**
     * Test of findFromYear method, of class ICarCollection.
     */
    @Test
    public void testFindFromYear() throws AlreadyExistsException
    {
        ICarCollection testSubject = getNewTestSubject();
        testSubject.addCar("ZZ50123", "Audi", "A4 Avant", 1999, "Black");
        testSubject.addCar("AB35728", "Toyota", "Corolla", 2002, "Green");
        testSubject.addCar("GA74829", "BMW", "i320", 2002, "Red");
        Collection<ICar> cars = testSubject.findFromYear(2002);
        assertEquals(cars.size(), 2);
        Iterator<ICar> it = cars.iterator();
        while(it.hasNext())
        {
            ICar car = it.next();
            assertEquals(car.getYear(), 2002);
        }
    }

    /**
     * Test of sortedByRegistrationNumber method, of class ICarCollection.
     */
    @Test
    public void testSortedByRegistrationNumber() throws AlreadyExistsException
    {
        ICarCollection testSubject = getNewTestSubject();
        testSubject.addCar("ZZ50123", "Audi", "A4 Avant", 1999, "Black");
        testSubject.addCar("AB35728", "Toyota", "Corolla", 2002, "Green");
        testSubject.addCar("GA74829", "BMW", "i320", 2002, "Red");
        Collection<ICar> cars = testSubject.sortedByRegistrationNumber();
        Iterator<ICar> it = cars.iterator();
        assertTrue(it.hasNext());
        ICar car = it.next();
        assertEquals(car.getRegistrationNumber(), "AB35728");
        assertTrue(it.hasNext());
        car = it.next();
        assertEquals(car.getRegistrationNumber(), "GA74829");
        assertTrue(it.hasNext());
        car = it.next();
        assertEquals(car.getRegistrationNumber(), "ZZ50123");
    }

    /**
     * Test of sortedByYear method, of class ICarCollection.
     */
    @Test
    public void testSortedByYear() throws AlreadyExistsException
    {
        ICarCollection testSubject = getNewTestSubject();
        testSubject.addCar("ZZ50123", "Audi", "A4 Avant", 2006, "Black");
        testSubject.addCar("AB35728", "Toyota", "Corolla", 2002, "Green");
        testSubject.addCar("GA74829", "BMW", "i320", 2008, "Red");
        Collection<ICar> cars = testSubject.sortedByYear();
        Iterator<ICar> it = cars.iterator();
        assertTrue(it.hasNext());
        ICar car = it.next();
        assertEquals(car.getYear(), 2002);
        assertTrue(it.hasNext());
        car = it.next();
        assertEquals(car.getYear(), 2006);
        assertTrue(it.hasNext());
        car = it.next();
        assertEquals(car.getYear(), 2008);
    }

    /**
     * Test of saveCarsToFile method, of class ICarCollection.
     */
    @Test
    public void testCarsToAndFromFile() throws AlreadyExistsException
    {
        ICarCollection testSubject = getNewTestSubject();
        testSubject.addCar("ZZ50123", "Audi", "A4 Avant", 2006, "Black");
        testSubject.addCar("AB35728", "Toyota", "Corolla", 2002, "Green");
        testSubject.addCar("GA74829", "BMW", "i320", 2008, "Red");
        testSubject.saveCarsToFile(new File("Cars.ca"));

        testSubject = getNewTestSubject();
        testSubject.readCarsFromFile(new File("Cars.ca"));
        Collection<ICar> cars = testSubject.sortedByRegistrationNumber();
        assertEquals(cars.size(), 3);
        Iterator<ICar> it = cars.iterator();
        assertTrue(it.hasNext());
        ICar car = it.next();
        assertEquals(car.getRegistrationNumber(), "AB35728");
        assertEquals(car.getBrand(), "Toyota");
        assertEquals(car.getModel(), "Corolla");
        assertEquals(car.getYear(), 2002);
        assertEquals(car.getColor(), "Green");
        assertTrue(it.hasNext());
        car = it.next();
        assertEquals(car.getRegistrationNumber(), "GA74829");
        assertEquals(car.getBrand(), "BMW");
        assertEquals(car.getModel(), "i320");
        assertEquals(car.getYear(), 2008);
        assertEquals(car.getColor(), "Red");
        assertTrue(it.hasNext());
        car = it.next();
        assertEquals(car.getRegistrationNumber(), "ZZ50123");
        assertEquals(car.getBrand(), "Audi");
        assertEquals(car.getModel(), "A4 Avant");
        assertEquals(car.getYear(), 2006);
        assertEquals(car.getColor(), "Black");

    }


    @Test(expected=AlreadyExistsException.class)
    public void testAlreadyExistsException() throws AlreadyExistsException
    {
        ICarCollection testSubject = getNewTestSubject();

        testSubject.addCar("ZZ50123", "Audi", "A4 Avant", 1999, "Black");
        testSubject.addCar("AB35728", "Toyota", "Corolla", 2002, "Green");
        testSubject.addCar("ZZ50123", "BMW", "i320", 2005, "Green");
    }
}