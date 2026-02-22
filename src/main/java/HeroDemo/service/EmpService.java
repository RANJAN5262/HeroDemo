package HeroDemo.service;

import HeroDemo.entity.Emp;
import HeroDemo.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    private final EmpRepo empRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    public EmpService(EmpRepo empRepo) {
        this.empRepo = empRepo;
    }

    // Create / Save
    public Emp saveEmp(Emp emp) {
        emp.setPassword(passwordEncoder.encode(emp.getPassword()));
        return empRepo.save(emp);
    }

    // Get all employees
    public List<Emp> getAllEmployees() {
        return empRepo.findAll();
    }

    // Get employee by ID
    public Optional<Emp> getById(int id) {
        return empRepo.findById(id);
    }

    // Update employee
    public Emp updateEmp(int id, Emp updates) {
        Optional<Emp> optionalEmp = empRepo.findById(id);

        if (optionalEmp.isEmpty()) {
            return null;
        }

        Emp existing = optionalEmp.get();

        if (updates.getName() != null) {
            existing.setName(updates.getName());
        }
        if (updates.getEmail() != null) {
            existing.setEmail(updates.getEmail());
        }
//        if (updates.getSalary() != null) {
//            existing.setSalary(updates.getSalary());
//        }

        return empRepo.save(existing);
    }

    // Delete employee
    public boolean deleteEmp(int id) {
        Optional<Emp> optionalEmp = empRepo.findById(id);

        if (optionalEmp.isEmpty()) {
            return false;
        }

        empRepo.delete(optionalEmp.get());
        return true;
    }
}