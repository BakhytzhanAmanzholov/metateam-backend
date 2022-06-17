package kz.metateam.hackday.service;

import kz.metateam.hackday.models.Role;

public interface RoleService extends CrudService<Role, Long>{
    Role findByName(String name);
}
