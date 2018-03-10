package com.company;


public class Car implements ICar
{

    private String RegNum;
    private String Brand;
    private String Model;
    private int Year;
    private String Color;

    public Car(String RegNum, String Brand, String Model, int Year, String Color)
    {
        this.RegNum = RegNum;
        this.Brand = Brand;
        this.Model = Model;
        this.Year = Year;
        this.Color = Color;
    }

    @Override
    public String toString()
    {
        return RegNum + "," + Brand + "," + Model + "," + Year + "," + Color;
    }

    @Override
    public String getRegistrationNumber()
    {
        return RegNum;
    }

    @Override
    public String getBrand()
    {
        return Brand;
    }

    @Override
    public String getModel()
    {
        return Model;
    }

    @Override
    public int getYear()
    {
        return Year;
    }

    @Override
    public String getColor()
    {
        return Color;
    }

}
