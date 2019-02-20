package ua.org.ostpc.ittools.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Project {


    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }

    @OneToMany(mappedBy="project")
    private List<Tasks> tasks;
    // private Set<Tasks> tasks = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private Set<Employees> employees = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String description;

    @Column
    private String startDate;

    @Column
    private String endDate;

    @Column
    private double payment;

    @Column
    private double projectVersion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getProjectVersion() {
        return projectVersion;
    }

    public void setProjectVersion(double projectVersion) {
        this.projectVersion = projectVersion;
    }

    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }

/*    public Set<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Tasks> tasks) {
        this.tasks = tasks;
    }*/
}
