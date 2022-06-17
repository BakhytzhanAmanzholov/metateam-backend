package kz.metateam.hackday.service;

import kz.metateam.hackday.models.Account;
import kz.metateam.hackday.models.test.Answer;
import kz.metateam.hackday.models.test.Question;

import java.util.List;

public interface AccountService extends CrudService<Account, Long> {
    void addRoleToUser(String email, String roleName);
    Account findByEmail(String email);
    List<Long> test(Question question, Answer answer, List<Long> longs);
}
