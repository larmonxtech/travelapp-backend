package com.xplorelatam.service.implementation;

import com.xplorelatam.model.Tag;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.repository.ITagRepository;
import com.xplorelatam.service.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagService extends GenericService<Tag, Integer> implements ITagService {
    private final ITagRepository repo;


    @Override
    protected IGenericRepository<Tag, Integer> getRepo() {
        return repo;
    }
}
