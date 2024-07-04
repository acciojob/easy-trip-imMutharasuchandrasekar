package com.driver.Service;

import com.driver.Repository.FlightRepo;
import com.driver.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    FlightRepo flightRepo;

    public String addFlight( Flight flight )
    {
        return flightRepo.addFlight( flight );
    }

}
