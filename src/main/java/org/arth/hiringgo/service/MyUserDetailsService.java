package org.arth.hiringgo.service;

import lombok.RequiredArgsConstructor;
import org.arth.hiringgo.model.User;
import org.arth.hiringgo.model.UserPrincipal;
import org.arth.hiringgo.repository.UserRepository;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@NullMarked
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User foundUser = userRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User with username: "+username+" is not found!"));
        return new UserPrincipal(foundUser);
    }

    public User register(User user) {
        String hashedPass = encoder.encode(user.getUserPass());
        user.setUserPass(hashedPass);
        return userRepo.save(user);
    }
}
