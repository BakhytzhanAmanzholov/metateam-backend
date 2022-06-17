package kz.metateam.hackday.service.implementation;

import kz.metateam.hackday.models.Role;
import kz.metateam.hackday.repository.RoleRepository;
import kz.metateam.hackday.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public Role update(Role entity) {
        Role role = findById(entity.getId());
        role.setName(entity.getName());
        return role;
    }

    @Override
    public void delete(Role entity) {
        roleRepository.delete(entity);
    }

    @Override
    public Role findById(Long aLong) {
        return roleRepository.findById(aLong).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
}
