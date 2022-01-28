package com.santosh.springbootjpa.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_date", nullable = false)
    private Date addedDate;

    @JoinColumn(name = "department_id", referencedColumnName = "id")
    @ManyToOne()
    private Department department;

    public User(Integer id) {
        this.id = id;
    }
}
