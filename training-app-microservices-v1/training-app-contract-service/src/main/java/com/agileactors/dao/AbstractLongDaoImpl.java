package com.agileactors.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.agileactors.data.jpa.repository.AbstractRepository;
import com.agileactors.domain.AbstractPersistable;

public abstract class AbstractLongDaoImpl<T extends AbstractPersistable<Long>, R extends AbstractRepository<T, Long>>
    extends AbstractDaoImpl<T, Long, R> implements AbstractDao<T, Long> {

    @Autowired
    public AbstractLongDaoImpl(R jpaRepository) {
        super(jpaRepository);
    }

}
