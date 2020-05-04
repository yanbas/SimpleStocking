package com.simplestocking.demo.security;

import com.simplestocking.demo.model.Users;
import com.simplestocking.demo.repository.UserAuthRepository;
import com.simplestocking.demo.repository.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UsersRepository usersRepository;

    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = usersRepository.getOne(username);
        if (users == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(users.getUserId(),users.getPassword(),emptyList());
    }

}
