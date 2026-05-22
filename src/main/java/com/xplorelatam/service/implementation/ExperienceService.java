package com.xplorelatam.service.implementation;

import com.xplorelatam.model.Experience;
import com.xplorelatam.repository.IExperienceRepository;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.service.IExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExperienceService extends GenericService<Experience, Integer> implements IExperienceService {

    private final IExperienceRepository repo;

    @Override
    protected IGenericRepository<Experience, Integer> getRepo() {
        return repo;
    }
}
