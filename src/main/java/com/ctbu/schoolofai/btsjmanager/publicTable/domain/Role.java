package com.ctbu.schoolofai.btsjmanager.publicTable.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" ,length = 20)
    private  long id;

    private  String role;
    /**
     * 教师
     */
    @ManyToMany(mappedBy="roles")
    private Set<Teacher> teachers=new HashSet<Teacher>();
}
