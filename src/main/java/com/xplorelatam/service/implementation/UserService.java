package com.xplorelatam.service.implementation;

import com.xplorelatam.model.User;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.repository.IUserRepository;
import com.xplorelatam.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends GenericService<User, Integer> implements IUserService {
    private final IUserRepository repo;
    private final PasswordEncoder bcrypt;

    @Override
    protected IGenericRepository<User, Integer> getRepo() {
        return repo;
    }

    @Override
    public User findOneByUsername(String username) {
        return repo.findOneByUsername(username);
    }

    @Override
    public void changePassword(String username, String newPassword) {
        repo.changePassword(username, bcrypt.encode(newPassword));
    }
}
