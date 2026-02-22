package HeroDemo.service;

import HeroDemo.entity.Role;
import HeroDemo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    // CREATE
    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    // READ ALL
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    // READ BY ID
    public Role getRoleById(int id) {
        return roleRepo.findById(id).orElse(null);
    }

    // UPDATE
    public Role updateRole(int id, Role updatedRole) {
        Optional<Role> optional = roleRepo.findById(id);
        if (optional.isPresent()) {
            Role existing = optional.get();
            existing.setName(updatedRole.getName());
            return roleRepo.save(existing);
        }
        return null;
    }

    // DELETE
    public boolean deleteRole(int id) {
        if (roleRepo.existsById(id)) {
            roleRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
