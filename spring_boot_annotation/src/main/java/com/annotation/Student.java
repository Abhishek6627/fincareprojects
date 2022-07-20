package com.annotation;

public class Student
{
     String  name;

    public Student() {
    }

    public Student(String name)
    {
        this.name = name;
    }

    public  void studying()
    {
        System.out.println(this.name+"i am studying");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
