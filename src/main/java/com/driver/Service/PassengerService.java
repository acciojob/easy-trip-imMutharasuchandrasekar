package com.driver.Service;

import com.driver.Repository.PassengerRepo;
import com.driver.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {


    @Autowired
    PassengerRepo passengerRepo;

    public String addPassenger(Passenger passenger) {
       return passengerRepo.addPassenger(passenger);
    }
}
