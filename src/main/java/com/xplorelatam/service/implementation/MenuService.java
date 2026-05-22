package com.xplorelatam.service.implementation;

import com.xplorelatam.model.Menu;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.repository.IMenuRepository;
import com.xplorelatam.service.IMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService extends GenericService<Menu, Integer> implements IMenuService {

    private final IMenuRepository repo;

    @Override
    protected IGenericRepository<Menu, Integer> getRepo() {
        return repo;
    }
}
