package com.example.sbertest.repo.abstr;

import com.example.sbertest.exceptions.ApiRequestException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

/**
 * Репозиторий. Запросы к БД.
 *
 * @param <T> сущность
 * @param <PK> ID
 */
public abstract class SberRepoAbstract<T, PK extends Serializable> implements SberRepo<T, PK> {

    @PersistenceContext
    private EntityManager entityManager;
    private final Class<T> clazz;

    @SuppressWarnings("unchecked")
    public SberRepoAbstract() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        clazz = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public Optional<T> getById(PK id) {
        TypedQuery<T> query = entityManager.createQuery(
                        "SELECT a FROM " + clazz.getSimpleName()+ " as a" + " WHERE a.id = :paramId", clazz)
                .setParameter("paramId", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void deleteById(PK id) {
        try {
            entityManager.remove(entityManager.find(clazz, id));
        } catch (IllegalArgumentException e) {
            throw new ApiRequestException("Entity does not exist");
        }
    }

    @Override
    public List<T> getAll() {
        return entityManager.createQuery("SELECT a FROM " + clazz.getSimpleName() + " as a").getResultList();
    }

    @Override
    public boolean existById(PK id) {
        Long count = entityManager.createQuery(
                        "SELECT count(b) " +
                                "FROM " + clazz.getSimpleName() + " b " +
                                "WHERE b.id = :paramId", Long.class)
                .setParameter("paramId", id)
                .getSingleResult();
        return (count > 0);
    }

    @Override
    public Long countRows() {
        return entityManager.createQuery(
                        "SELECT count(b) " +
                                "FROM " + clazz.getSimpleName() + " b ", Long.class)
                .getSingleResult();
    }
}
