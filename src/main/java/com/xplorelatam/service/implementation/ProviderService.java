package com.xplorelatam.service.implementation;

import com.xplorelatam.model.Provider;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.repository.IProviderRepository;
import com.xplorelatam.service.IProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderService extends GenericService<Provider, Integer> implements IProviderService {

    private final IProviderRepository repo;

    @Override
    protected IGenericRepository<Provider, Integer> getRepo() {
        return repo;
    }
}
