package com.xplorelatam.service.implementation;

import com.xplorelatam.model.Category;
import com.xplorelatam.repository.ICategoryRepository;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService extends GenericService<Category, Integer> implements ICategoryService {
    private final ICategoryRepository repo;

    @Override
    protected IGenericRepository<Category, Integer> getRepo() {
        return repo;
    }

    /*@Override
    public Category save(Category category) throws Exception {
        return repo.save(category);
    }

    @Override
    public Category update(Category category, Integer id) throws Exception {
        // TODO Logica utilizando ID
        return repo.save(category);
    }

    @Override
    public List<Category> findAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Category findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Category());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }

     */
}
