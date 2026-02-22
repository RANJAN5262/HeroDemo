package HeroDemo.repository;

import HeroDemo.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Emp, Integer> {
}
