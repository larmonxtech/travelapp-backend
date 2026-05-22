package com.xplorelatam.service.implementation;

import com.xplorelatam.model.Role;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.repository.IRoleRepository;
import com.xplorelatam.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService extends GenericService<Role, Integer> implements IRoleService {

    private final IRoleRepository repo;

    @Override
    protected IGenericRepository<Role, Integer> getRepo() {
        return repo;
    }
}
