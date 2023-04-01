package com.example.test3103.service;

import java.util.Optional;

public interface IGen<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
