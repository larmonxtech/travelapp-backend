package com.xplorelatam.service;

import com.xplorelatam.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService extends IGenericService<Category,Integer> {
    /*Category save(Category category) throws Exception;
    Category update(Category category, Integer id) throws Exception;
    List<Category> findAll() throws Exception;
    Category findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;

     */
    //List<Category> findTopTen() throws Exception;

    Page<Category> listPage(Pageable pageable);
}
