package kz.metateam.hackday.service.implementation;

import kz.metateam.hackday.models.Account;
import kz.metateam.hackday.models.Role;
import kz.metateam.hackday.models.test.Answer;
import kz.metateam.hackday.models.test.Question;
import kz.metateam.hackday.repository.AccountRepository;
import kz.metateam.hackday.repository.RoleRepository;
import kz.metateam.hackday.service.AccountService;
import kz.metateam.hackday.service.QuestionService;
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
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AccountServiceImpl implements AccountService, UserDetailsService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final QuestionService questionService;


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

    @Override
    public List<Long> test(Question question, Answer answer, List<Long> longs) {
        if(longs.size()==0){
            longs.add(question.getId());
            longs.add(0L);
            longs.add(0L);
            longs.add(0L);
            longs.add(0L);
            longs.add(0L);
        }
        switch (answer.getType().getName()){
            case ("Реалистический тип"):
                longs.set(1, longs.get(1) + 1);
                break;
            case ("Интеллектуальный тип"):
                longs.set(2, longs.get(2) + 1);
                break;
            case ("Артистичный тип"):
                longs.set(3, longs.get(3) + 1);
                break;
            case ("Социальный тип"):
                longs.set(4, longs.get(4) + 1);
                break;
            case ("Предприимчивый тип"):
                longs.set(5, longs.get(5) + 1);
                break;
            case ("Традиционный"):
                longs.set(6, longs.get(6) + 1);
                break;
            default:
                break;
        }
        Question question1 = questionService.findById(question.getId()+1);
        if(question1 == null){
            longs.set(0, -1L);
        }
        else {
            longs.set(0, question1.getId());
        }
        return longs;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
