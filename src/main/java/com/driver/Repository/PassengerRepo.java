package com.driver.Repository;

import com.driver.model.Passenger;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class PassengerRepo {

    public HashMap<Integer, Passenger> passengerHashMap = new HashMap<>();

    public String addPassenger(Passenger passenger)
    {
        if( !passengerHashMap.containsKey( passenger.getPassengerId() ) )
        {
            passengerHashMap.put(passenger.getPassengerId(), passenger);
            return "SUCCESS";
        }
        return null;
    }
}
