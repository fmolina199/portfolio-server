package com.salvadordavi.portfolio.repository;

import com.salvadordavi.portfolio.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
