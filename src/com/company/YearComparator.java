package com.company;

import java.util.Comparator;

public class YearComparator implements Comparator<ICar>
{

    @Override
    public int compare(ICar c1, ICar c2)
    {
        return c1.getYear()-c2.getYear();
    }

}
