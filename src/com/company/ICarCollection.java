package com.company;

import java.io.File;
import java.util.Collection;

public interface ICarCollection
/*
This interface should be implemented to solve all the the exercises. Initially you must create a class that implements ICar.
*/
{
    // 1: add a car to the collection of cars (not to the text file)
    Collection<ICar> addCar(String registrationNumber, String brand, String model, int year, String color) throws AlreadyExistsException;
    // 2: get all the cars in the collection (the cars that were read from the textfile into the java collection - i.e. List, Map etc..
    Collection<ICar> getAllCars();
    // 3: remove a car from the collection of cars
    boolean removeCar(String registrationNumber);
    // 4: return the unique car with the given registration number or null if it does not exist.
    // Ideally it should return in constant time independently of the number of cars in the collection.
    ICar findFromRegistrationNumber(String registrationNumber);
    // 5: return a java list as a subset of the cars collection containing only cars from that exact production year.
    Collection<ICar> findFromYear(int year);
    // 6: return a java list of all the cars sorted by registration number
    Collection<ICar> sortedByRegistrationNumber();
    // 7: return a java list of all the cars sorted by production year.
    Collection<ICar> sortedByYear();
    // 8: this method takes the collection and writes it back to the text file.
    void saveCarsToFile(File file);
    // 9: this method does not return anything but it should read all cars from a text file into this collection
    void readCarsFromFile(File file);
}

