package com.example.sbertest.repo.abstr;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface SberRepo<T, PK extends Serializable> {
    void create(T entity);

    void update(T entity);

    Optional<T> getById(PK id);

    void deleteById(PK id);

    List<T> getAll();

    boolean existById(PK id);

    Long countRows();
}
