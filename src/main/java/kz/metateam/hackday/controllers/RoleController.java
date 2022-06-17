package kz.metateam.hackday.controllers;

import kz.metateam.hackday.models.Role;
import kz.metateam.hackday.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/roles")
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody String roleName) {
        if(roleService.findByName(roleName) != null){
            return new ResponseEntity<>("Role is already created!", HttpStatus.BAD_REQUEST);
        }
        Role role = new Role(roleName);
        roleService.save(role);
        return new ResponseEntity<>("Role create successfully", HttpStatus.OK);
    }
}
