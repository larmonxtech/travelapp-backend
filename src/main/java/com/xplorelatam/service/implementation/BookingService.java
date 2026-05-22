package com.xplorelatam.service.implementation;

import com.xplorelatam.model.Booking;
import com.xplorelatam.repository.IBookingRepository;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.service.IBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService extends GenericService<Booking, Integer> implements IBookingService {

    private final IBookingRepository repo;

    @Override
    protected IGenericRepository<Booking, Integer> getRepo() {
        return repo;
    }
}
