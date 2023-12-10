package com.agileactors.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import com.agileactors.domain.AbstractPersistable;

public interface AbstractDao<T extends AbstractPersistable, I extends Serializable> {

  Optional<T> findById(I id);

  List<T> findAll();

  List<T> findAllById(Iterable<I> ids);

  T getById(I id);

  T save(T entity);

  T saveAndFlush(T entity);

  List<T> saveAll(List<T> entities);

  void deleteById(I id);

  void delete(T entity);
}
