package com.example.test3103.repository;

import com.example.test3103.model.Category;
import com.example.test3103.model.Painting;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaintingRepo extends PagingAndSortingRepository<Painting, Long> {
    Iterable<Painting> findAllByCategory(Category category);

    Painting findByName(String name);
}
