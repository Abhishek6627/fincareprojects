package com.validation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_TBL")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int userId;
    private  String name;
    private  String email;
    private  String  mobile;
    private  String   gender;
    private  int age;
    private  String nationality;


}
