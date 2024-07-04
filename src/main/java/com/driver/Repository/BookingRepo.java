package com.driver.Repository;


import com.driver.model.Bookings;
import com.driver.model.Flight;
import com.driver.model.Passenger;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class BookingRepo {

    // key - passengerId, value - Bookings
    public HashMap<Integer, ArrayList<Bookings> > bookingsHashMap = new HashMap<>();

    public String bookTicket(Passenger passenger, Flight flight )
    {
        Bookings booking = new Bookings();
        booking.setFlight( flight );
        booking.setPassenger( passenger );

        if( bookingsHashMap.containsKey( passenger.getPassengerId()) )
        {
            ArrayList<Bookings> list = bookingsHashMap.get( passenger.getPassengerId() );
            list.add( booking );
            bookingsHashMap.put( passenger.getPassengerId(), list );
        }
        else {
            ArrayList<Bookings> newlist = new ArrayList<>();
            newlist.add( booking );
            bookingsHashMap.put( passenger.getPassengerId(), newlist );
        }
        return "SUCCESS";
    }

}
