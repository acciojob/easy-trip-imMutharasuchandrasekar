package com.driver.Repository;

import com.driver.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class FlightRepo {

    public HashMap<Integer, Flight> flightHashMap = new HashMap<>();

    public String addFlight( Flight flight )
    {
        if( !flightHashMap.containsKey( flight.getFlightId() ) )
        {
            flightHashMap.put( flight.getFlightId(), flight );
            return "SUCCESS";
        }
        return null;
    }
}
