package com.agileactors.data.jpa.repository;

import com.agileactors.domain.User;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends AbstractRepository<User, UUID> {
  User findByEmail(String email);
}
