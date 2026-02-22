package HeroDemo.controller;

import HeroDemo.entity.Emp;
import HeroDemo.service.EmpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/public/emp")
public class EmpCont {

    private final EmpService empService;

    public EmpCont(EmpService empService) {
        this.empService = empService;
    }

    // GET all
    @GetMapping
    public ResponseEntity<List<Emp>> getAll() {
        List<Emp> list = empService.getAllEmployees();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // GET one employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Optional<Emp> optionalEmp = empService.getById(id);

        if (optionalEmp.isEmpty()) {
            return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalEmp.get(), HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<Emp> add(@RequestBody Emp emp) {
        Emp saved = empService.saveEmp(emp);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Emp updates) {
        Emp updated = empService.updateEmp(id, updates);

        if (updated == null) {
            return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean deleted = empService.deleteEmp(id);

        if (!deleted) {
            return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
    }
}