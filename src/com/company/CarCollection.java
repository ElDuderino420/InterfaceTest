package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CarCollection implements ICarCollection
{

    private List<ICar> Cars;
    private Map<String, ICar> RegMap;
    private String line;

    public CarCollection()
    {
        this.Cars = new ArrayList<>();
        this.RegMap = new TreeMap<>();
    }

    public CarCollection(List<ICar> carslist)
    {
        this.Cars = carslist;
        this.RegMap = new TreeMap<>();
    }

    @Override
    public void addCar(String registrationNumber, String brand, String model, int year, String color) throws AlreadyExistsException
    {
        for (ICar Car : Cars)
        {
            if (Car.getRegistrationNumber().equals(registrationNumber))
            {
                throw new AlreadyExistsException(registrationNumber);
            }
        }
        Cars.add(new Car(registrationNumber, brand, model, year, color));
        RegMap.put(registrationNumber, new Car(registrationNumber, brand, model, year, color));
    }

    @Override
    public Collection<ICar> getAllCars()
    {
        return Cars;
    }

    @Override
    public boolean removeCar(String registrationNumber)
    {
        for (ICar Car : Cars)
        {
            if (Car.getRegistrationNumber().equals(registrationNumber))
            {
                Cars.remove(Car);
                RegMap.remove(registrationNumber);
                return true;
            }
        }
        return false;
    }

    @Override
    public ICar findFromRegistrationNumber(String registrationNumber)
    {
        return RegMap.get(registrationNumber);
    }

    @Override
    public Collection<ICar> findFromYear(int year)
    {
        ICarCollection YCollec = new CarCollection();
        for (ICar Car : Cars)
        {
            if (Car.getYear() == year)
            {
                try
                {
                    YCollec.addCar(Car.getRegistrationNumber(), Car.getBrand(), Car.getModel(), Car.getYear(), Car.getColor());
                } catch (AlreadyExistsException e)
                {
                    System.err.format(e.toString());
                }
            }
        }
        return YCollec.getAllCars();
    }

    @Override
    public Collection<ICar> sortedByRegistrationNumber()
    {
        return RegMap.values();

    }

    @Override
    public Collection<ICar> sortedByYear()
    {
        Comparator comp = new YearComparator();
        Collections.sort(Cars,comp);
        return getAllCars();
    }

    @Override
    public void saveCarsToFile(File file)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file)))
        {
            for (ICar Car : Cars)
            {
                writer.append(Car.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }
    }

    @Override
    public void readCarsFromFile(File file)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            while ((line = reader.readLine()) != null)
            {
                String[] car = line.split(",");
                try
                {
                    addCar(car[0], car[1], car[2], Integer.parseInt(car[3]), car[4]);
                } catch (AlreadyExistsException e)
                {
                    System.err.format(e.toString());
                }
            }
            reader.close();
        } catch (IOException x)
        {
            System.err.format("IOException: %s%n", x);
        }

    }

}