package org.example.Models;

public class Operator extends BaseModel {

    private String name;
    private String emp_id;

    public Operator(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "name='" + name + '\'' +
                ", emp_id='" + emp_id + '\'' +
                "} " + super.toString();
    }
}
