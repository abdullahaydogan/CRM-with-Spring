package com.CRM.crm.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryI extends JpaRepository<User, Long> {
    User findByActivationToken(String token);

    User findByUserEmail(String userEmail);

}
