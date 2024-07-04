package com.driver.Repository;

import com.driver.model.Airport;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AirportRepo {

    // Key - NoOfTerminals, value - airport
    public HashMap<Integer, Airport> airportHashMap = new HashMap<>();

    public String addAirport(Airport airport) {
        if( !airportHashMap.containsKey( airport.getNoOfTerminals() ) )
        {
            airportHashMap.put( airport.getNoOfTerminals(), airport );
            return "SUCCESS";
        }
        return null;
    }
}
