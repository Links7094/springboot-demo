package com.example.demo.api.validator;


import javax.validation.constraints.NotBlank;

public class Company {

    private int id;
    @NotBlank(message = "company.name can't be blank")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
