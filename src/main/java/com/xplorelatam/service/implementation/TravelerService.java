package com.xplorelatam.service.implementation;

import com.xplorelatam.model.Traveler;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.repository.ITravelerRepository;
import com.xplorelatam.service.ITravelerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TravelerService extends GenericService<Traveler, Integer> implements ITravelerService {

    private final ITravelerRepository repo;

    @Override
    protected IGenericRepository<Traveler, Integer> getRepo() {
        return repo;
    }
}
