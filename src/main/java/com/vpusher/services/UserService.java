package com.vpusher.services;

import com.vpusher.domains.User;
import com.vpusher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by f2i on 4/5/17.
 */
@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository UserRepository) {
        this.userRepository = UserRepository;
    }

    public User get(Long id) {
        return this.userRepository.findOne(id);
    }

    public Iterable<User> all() {
        return this.userRepository.findAll();
    }

    public void update(User User) {
        this.userRepository.save(User);
    }

    public void remove(User User) {
        this.userRepository.delete(User);
    }

    public void clean() {
        this.userRepository.deleteAll();
    }

}