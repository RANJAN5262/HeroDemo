package HeroDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data                   // Generates getters, setters, toString, equals, hashCode
@NoArgsConstructor      // No-args constructor
@AllArgsConstructor     // All-args constructor
@Builder
@Table (name = "Employee")// Builder pattern
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private double salary;
    private String password;
}
