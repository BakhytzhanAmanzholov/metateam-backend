package kz.metateam.hackday.service;

import kz.metateam.hackday.models.Account;

public interface AccountService extends CrudService<Account, Long> {
    void addRoleToUser(String email, String roleName);
    Account findByEmail(String email);
}
