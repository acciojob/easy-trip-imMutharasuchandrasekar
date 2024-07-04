package com.driver.Service;

import com.driver.Repository.BookingRepo;
import com.driver.Repository.FlightRepo;
import com.driver.Repository.PassengerRepo;
import com.driver.model.Bookings;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    FlightRepo flightRepo;

    @Autowired
    PassengerRepo passengerRepo;

    @Autowired
    BookingRepo bookingRepo;

    public String bookATicket( Integer flightId, Integer passengerId )
    {
        if( !flightRepo.flightHashMap.containsKey(flightId) )
        {
            return "FAILURE";
        }
        else if( !passengerRepo.passengerHashMap.containsKey(passengerId) )
        {
            return "FAILURE";
        }
        else if( bookingRepo.bookingsHashMap.containsKey(passengerId) ){
            // Passenger already booked.
            return "FAILURE";
        }
        else
        {
           Flight flight = flightRepo.flightHashMap.get(flightId);
           Passenger passenger = passengerRepo.passengerHashMap.get(passengerId);

           return bookingRepo.bookTicket( passenger, flight );
        }
    }

    public String cancelATicket(Integer flightId, Integer passengerId) {

        if( !bookingRepo.bookingsHashMap.containsKey(passengerId) )
        {
            // The passenger don't have any bookings
            return "FAILURE";
        }
        ArrayList<Bookings> booking = bookingRepo.bookingsHashMap.get( passengerId );
        Iterator<Bookings> iterator = booking.iterator();

        String state = "FAILURE";
        while( iterator.hasNext()  )
        {
            Bookings Currentbooking = iterator.next();
            if( Currentbooking.getFlight().getFlightId() == flightId )
            {
                iterator.remove();

                state = "SUCCESS";
            }
        }
        if( state == "SUCCESS" )
        {
            // Deletion is performed, have to update the repo.
            bookingRepo.bookingsHashMap.put( passengerId, booking );
        }
        return state;
    }
}
