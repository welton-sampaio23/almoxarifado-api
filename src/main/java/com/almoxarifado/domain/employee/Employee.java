package com.almoxarifado.domain.employee;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tbl_employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idEmployee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idEmployee;
    private String nameEmployee;
    private String profession;

    public Employee(String name, String profession) {
        this.nameEmployee = name;
        this.profession = profession;
    }
}
