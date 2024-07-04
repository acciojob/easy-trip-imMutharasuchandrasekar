package com.driver.Service;

import com.driver.Repository.AirportRepo;
import com.driver.model.Airport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class AirportService {

    @Autowired
    AirportRepo airportRepo;

    public String addAirport(Airport airport) {
        return airportRepo.addAirport( airport );
    }

    public String getLargestAirportByName()
    {
        List<Integer> keys = new ArrayList<>( airportRepo.airportHashMap.keySet() );

        Collections.sort( keys, Collections.reverseOrder() );

        Integer LargestKey = keys.get(0);
        Integer SecondLargestKey = 0;
        if( keys.size() >= 2 )
        {
            SecondLargestKey = keys.get(1);
        }

        if( LargestKey == SecondLargestKey )
        {
            String smallestAirportName = null;
            for( Map.Entry<Integer, Airport> entry : airportRepo.airportHashMap.entrySet() )
            {
                String currentName = entry.getValue().getAirportName();
                if( smallestAirportName == null || currentName.compareTo( smallestAirportName ) < 0 )
                {
                    smallestAirportName = currentName;
                }
            }
            return  smallestAirportName;
        }
        else
        {
            Airport airport = airportRepo.airportHashMap.get( LargestKey );
            return airport.getAirportName();
        }
    }
}
