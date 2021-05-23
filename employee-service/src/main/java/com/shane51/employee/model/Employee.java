package com.shane51.employee.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class Employee {

    private Long id;
    private String name;
    private String password;
    private Role role;
    private int age;
    private Long organizationId;
    private Long departmentId;

    public Employee() {}

    public Employee(Long id, String name, String password, Role role, int age, Long organizationId, Long departmentId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.age = age;
        this.organizationId = organizationId;
        this.departmentId = departmentId;
    }

    public Employee(long id, String name, String password, Role role) {
    }

    public Employee(String name, String secret, Role role) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", age=" + age +
                ", organizationId=" + organizationId +
                ", departmentId=" + departmentId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && id.equals(employee.id) && Objects.equals(name, employee.name) && Objects.equals(password, employee.password) && role == employee.role && Objects.equals(organizationId, employee.organizationId) && Objects.equals(departmentId, employee.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password, role, age, organizationId, departmentId);
    }
}
