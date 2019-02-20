package ua.org.ostpc.ittools.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employees {

    @ManyToMany
    @JoinTable(name="employees_employeeRoles",
            joinColumns = @JoinColumn(name="employees_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="employeeRoles_id", referencedColumnName="id")
    )

    private Set<EmployeeRoles> employeeRoles = new HashSet<>();


    @ManyToMany
    @JoinTable(name="employees_tasks",
            joinColumns = @JoinColumn(name="employees_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="tasks_id", referencedColumnName="id")
    )
    private Set<Tasks> tasks = new HashSet<>();

    @ManyToMany
    @JoinTable(name="employees_project",
            joinColumns = @JoinColumn(name="employees_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="project_id", referencedColumnName="id")
    )
    private Set<Project> project = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String fullName;

    @Column
    private double salary;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    public Set<EmployeeRoles> getEmployeeRoles() {
        return employeeRoles;
    }

    public void setEmployeeRoles(Set<EmployeeRoles> employeeRoles) {
        this.employeeRoles = employeeRoles;
    }

    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }


}
