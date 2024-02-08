package com.example.phonebookapi.Security;
import com.example.phonebookapi.Dtos.UserSecDto;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
class CustomUserDetailsService implements UserDetailsService {

    private final UserSecService userSecService;

    public CustomUserDetailsService(UserSecService userSecService) {
        this.userSecService = userSecService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userSecService.findCredentialsByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", username)));
    }

    private UserDetails createUserDetails(UserSecDto credentials) {
        return User.builder()
                .username(credentials.email())
                .password(credentials.password())
                .roles(credentials.roles().toArray(String[]::new))
                .build();
    }
}
