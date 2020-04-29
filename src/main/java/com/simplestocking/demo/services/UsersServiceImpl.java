package com.simplestocking.demo.services;

import com.simplestocking.demo.model.Employee;
import com.simplestocking.demo.model.Users;
import com.simplestocking.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users create(Users users) {
        users.setCreated_date(new Date());
        return usersRepository.save(users);
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(String id) {
        return usersRepository.findById(id);
    }
}
