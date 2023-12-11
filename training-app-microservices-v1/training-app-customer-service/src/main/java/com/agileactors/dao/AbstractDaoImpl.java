package com.agileactors.dao;

import com.agileactors.data.jpa.repository.AbstractRepository;
import com.agileactors.domain.AbstractPersistable;
import com.agileactors.exception.ResourceNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDaoImpl<T extends AbstractPersistable<I>, I extends Serializable, R extends AbstractRepository<T, I>>
    implements AbstractDao<T, I> {

  protected R jpaRepository;

  @Autowired
  public AbstractDaoImpl(R jpaRepository) {
    this.jpaRepository = jpaRepository;
  }

  @Override
  public List<T> findAll() {
    return jpaRepository.findAll();
  }

  @Override
  public List<T> findAllById(Iterable<I> ids) {
    return jpaRepository.findAllById(ids);
  }

  @Override
  public Optional<T> findById(I id) {
    return jpaRepository.findById(id);
  }

  @Override
  public T getById(I id) {
    return jpaRepository.findById(id)
        .orElseThrow(
            () -> new ResourceNotFoundException(String.format("Resource[%s] not found", id)));
  }

  @Override
  public T save(T entity) {
    return jpaRepository.save(entity);
  }

  @Override
  public T saveAndFlush(T entity) {
    return jpaRepository.saveAndFlush(entity);
  }

  @Override
  public List<T> saveAll(List<T> entities) {
    return jpaRepository.saveAll(entities);
  }

  @Override
  public void deleteById(I id) {
    jpaRepository.deleteById(id);
  }

  @Override
  public void delete(T entity) {
    jpaRepository.delete(entity);
  }

}
