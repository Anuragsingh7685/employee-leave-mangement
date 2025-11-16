package com.example.employeeleavemanagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String email;

    private String name;

    private String role; // e.g., EMPLOYEE, MANAGER, ADMIN

    private String password; // plaintext here for demo; use hashing in real app
}
