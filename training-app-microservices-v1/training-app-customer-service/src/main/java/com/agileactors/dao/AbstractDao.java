package com.agileactors.dao;

import com.agileactors.domain.AbstractPersistable;
import com.agileactors.exception.ResourceNotFoundException;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface AbstractDao<T extends AbstractPersistable, I extends Serializable> {

  Optional<T> findById(I id);

  List<T> findAll();

  List<T> findAllById(Iterable<I> ids);

  T getById(I id) throws ResourceNotFoundException;

  T save(T entity);

  T saveAndFlush(T entity);

  List<T> saveAll(List<T> entities);

  void deleteById(I id);

  void delete(T entity);
}
