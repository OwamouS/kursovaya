package com.ifmo.isdb.DB.serviceImpls;

import com.ifmo.isdb.DB.pojo.Passenger;
import com.ifmo.isdb.DB.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PassengerServiceImpl implements UserDetailsService {
    @Autowired
    PassengerService passengerService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Passenger passenger = findPassengerByLogin(login);

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (passenger != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(login);
            builder.password(passenger.getPassword().toString());
            builder.roles(passenger.getPermission().toString());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }

    private Passenger findPassengerByLogin(String login) {
        return passengerService.getPassenger(login);

    }
}
