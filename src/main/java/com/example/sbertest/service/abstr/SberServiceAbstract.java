package com.example.sbertest.service.abstr;

import com.example.sbertest.repo.abstr.SberRepo;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Сервис по работе с репозиторием
 * @param <T>  сущность
 * @param <PK>  ID
 */
@Slf4j
public abstract class SberServiceAbstract<T, PK extends Serializable> implements SberService<T, PK> {
    private final SberRepo<T, PK> sberRepo;

    public SberServiceAbstract(SberRepo<T, PK> sberRepo) {
        this.sberRepo = sberRepo;
    }

    @Override
    @Transactional
    public void create(T entity) {
        log.info("Class: {}, create({})", getClass(), entity.getClass());
        sberRepo.create(entity);
    }

    @Override
    @Transactional
    public void update(T entity) {
        log.info("Class: {}, update({})", getClass(), entity.getClass());
        sberRepo.update(entity);
    }

    @Override
    @Transactional
    public Optional<T> getById(PK id) {
        log.info("Class: {}, getById({})", getClass(), id);
        return sberRepo.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(PK id) {
        log.info("Class: {}, deleteById({})", getClass(), id);
        sberRepo.deleteById(id);
    }

    @Override
    @Transactional
    public List<T> getAll() {
        log.info("Class: {}, getAll()", getClass());
        return sberRepo.getAll();
    }

    @Override
    @Transactional
    public boolean existById(PK id) {
        log.info("Class: {}, existById({})", getClass(), id);
        return sberRepo.existById(id);
    }

    @Override
    @Transactional
    public Long countRows() {
        log.info("Class: {}, countRows()", getClass());
        return sberRepo.countRows();
    }
}
