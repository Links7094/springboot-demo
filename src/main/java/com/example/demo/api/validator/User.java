package com.example.demo.api.validator;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "名字不能为空字符串")
    private String name;
    private int age;
    @Valid()
    private Company company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
