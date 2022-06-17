package kz.metateam.hackday.service.implementation;

import kz.metateam.hackday.models.Account;
import kz.metateam.hackday.models.Role;
import kz.metateam.hackday.repository.AccountRepository;
import kz.metateam.hackday.repository.RoleRepository;
import kz.metateam.hackday.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService, UserDetailsService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Account save(Account entity) {
        log.info("Saving new User {}", entity.getEmail());
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        Account account = accountRepository.save(entity);
        addRoleToUser(account.getEmail(), "ROLE_USER");
        return account;
    }

    @Override
    public Account update(Account entity) {
        log.info("Update user info {}", entity.toString());
        Account account = accountRepository.findByEmail(entity.getEmail());
        account.setFirstName(entity.getFirstName());
        account.setSecondName(entity.getSecondName());
        return account;
    }

    @Override
    public void delete(Account entity) {
        log.info("Delete user {}", entity.getEmail());
        accountRepository.delete(entity);
    }

    @Override
    public Account findById(Long aLong) {
        log.info("Find user by id {}", aLong);
        return accountRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = accountRepository.findByEmail(email);
        if (user == null) {
            log.error("User not found");
            throw new UsernameNotFoundException("User not found");
        } else {
            log.info("User found {}", user.getEmail());
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        log.info("Adding role {} to user {}", roleName, email);
        Account account = accountRepository.findByEmail(email);
        Role role = roleRepository.findByName(roleName);
        account.getRoles().add(role);
    }

    @Override
    public Account findByEmail(String email) {
        log.info("Find user by email {}", email);
        return accountRepository.findByEmail(email);
    }
}
