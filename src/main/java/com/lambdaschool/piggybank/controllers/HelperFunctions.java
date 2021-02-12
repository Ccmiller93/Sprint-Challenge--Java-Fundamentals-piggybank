package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;


import java.util.ArrayList;
import java.util.List;

public class HelperFunctions
{
    public static List<Coin> findCoins(List<Coin> fullList, CheckPiggyBank tester)
    {
        List<Coin> tempPig = new ArrayList<>();

        for (Coin c : fullList)
        {
            if (tester.test(c))
            {
                tempPig.add(c);
            }
        }

        return tempPig;
    }
}