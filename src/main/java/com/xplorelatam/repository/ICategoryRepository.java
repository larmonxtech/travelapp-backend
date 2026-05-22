package com.xplorelatam.repository;

import com.xplorelatam.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends IGenericRepository<Category, Integer> {
}
