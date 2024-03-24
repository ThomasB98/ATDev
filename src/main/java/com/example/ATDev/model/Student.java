package com.example.ATDev.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Student",
        uniqueConstraints = {
            @UniqueConstraint(
                    name = "rollno",
                    columnNames = "rollno"
            )
        }
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "rollno",nullable = false)
    private Long rollno;
    @Column(name = "Classroom")
    private String Classroom;
    @Column(name = "address")
    private String address;
}
