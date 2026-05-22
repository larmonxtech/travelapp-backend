package com.xplorelatam.service.implementation;

import com.xplorelatam.model.User;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.repository.IUserRepository;
import com.xplorelatam.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends GenericService<User, Integer> implements IUserService {

    private final IUserRepository repo;

    @Override
    protected IGenericRepository<User, Integer> getRepo() {
        return repo;
    }
}
