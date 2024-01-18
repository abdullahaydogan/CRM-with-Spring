package com.CRM.crm.user;

import com.CRM.crm.exception.InvalidTokenException;
import com.CRM.crm.user.dto.UserUpdate;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.MailException;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepositoryI userRepositoryI;

    @Transactional(rollbackOn = MailException.class)
    void userSave(User user) {
        try {
            user.setActivationToken(UUID.randomUUID().toString());
            userRepositoryI.saveAndFlush(user);
            // emailService.sendActivationEmail(user.getUserEmail(),user.getActivationToken());

        } catch (DataIntegrityViolationException exception) {
            throw new RuntimeException("User cant created");
        }
    }

    public void activeUser(String token) {
        User inDB = userRepositoryI.findByActivationToken(token);
        if (inDB == null) {
            throw new InvalidTokenException();
        }
        inDB.setActive(true);
        inDB.setActivationToken(null);
        userRepositoryI.save(inDB);
    }

    public Page<User> getUsers(Pageable page, User loggedInUser) {
        return userRepositoryI.findAll(page);
    }

    public User findByUserEmail(String userEmail) {
        return userRepositoryI.findByUserEmail(userEmail);
    }

    public User getUser(Long id) {
        return userRepositoryI.findById(id).orElseThrow(RuntimeException::new);
    }

    public User userUpdate(Long id, UserUpdate userUpdate) {
        User inDB = getUser(id);
        inDB.setUserName(userUpdate.userName());
        return userRepositoryI.save(inDB);
    }
}

