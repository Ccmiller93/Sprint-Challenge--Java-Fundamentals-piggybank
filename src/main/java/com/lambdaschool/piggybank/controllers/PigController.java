// Create an endpoint http://localhost:2019/total that prints to console the contents of the Piggy Bank as follows and returns an HTTP Status of OK

package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.PigRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.List;

@RestController
public class PigController
{

    @Autowired
    PigRepository pigrepos;

    @GetMapping(value = "/total",
            produces = {"application/json"})

    public ResponseEntity<?> getAllCoins()
    {
        List<Coin> myList = new ArrayList<>();
        pigrepos.findAll()
                .iterator()
                .forEachRemaining(myList::add);

        long total = 0;
        for (Coin c : myList)
        {
            total = total + c.getQuantity() * c.getValue();
        }
        if (total == 1)
        {
            myList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        } else
        {
            myList.sort((c1, c2) -> c1.getNameplural().compareToIgnoreCase(c2.getNameplural()));
        }

        System.out.println("The Piggy Bank holds" + total);

        return new ResponseEntity<>(myList,
                HttpStatus.OK);
    }
}
