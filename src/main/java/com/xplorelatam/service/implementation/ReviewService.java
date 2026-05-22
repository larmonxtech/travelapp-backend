package com.xplorelatam.service.implementation;

import com.xplorelatam.model.Review;
import com.xplorelatam.repository.IGenericRepository;
import com.xplorelatam.repository.IReviewRepository;
import com.xplorelatam.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService extends GenericService<Review, Integer> implements IReviewService {

    private final IReviewRepository repo;

    @Override
    protected IGenericRepository<Review, Integer> getRepo() {
        return repo;
    }
}
