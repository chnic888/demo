package com.chnic.demo.repository;

import com.chnic.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author xxx
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Search user list by full user name
     * @param name user name
     * @return search result, maybe null
     */
    Optional<List<User>> findByName(String name);
}
