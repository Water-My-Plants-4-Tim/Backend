package com.elton.watermyplants.Services;

import com.elton.watermyplants.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.elton.watermyplants.Models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "securityUserService")
public class SecurityUserServiceIMPL implements UserDetailsService
{

    @Autowired
    private UserRepo userRepository;


    @Transactional
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException
    {
        User user = userRepository.findByEmail(s.toLowerCase());

        if (user == null)
        {
            throw new UsernameNotFoundException("Invalid Password or Username.");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getAuthority());
    }
}
