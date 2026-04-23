package com.xplorelatam.service.implementation;

import com.xplorelatam.model.Tag;
import com.xplorelatam.repository.ITagRepository;
import com.xplorelatam.service.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagService implements ITagService {
    private final ITagRepository repo;

    @Override
    public Tag save(Tag tag) throws Exception {
        return repo.save(tag);
    }

    @Override
    public Tag update(Tag tag, Integer id) throws Exception {
        // TODO Logica utilizando ID
        return repo.save(tag);
    }

    @Override
    public List<Tag> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Tag findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Tag());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
