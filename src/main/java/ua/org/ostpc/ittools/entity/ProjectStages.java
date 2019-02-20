package ua.org.ostpc.ittools.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ProjectStages {

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "projectStages")
    private Set<EmployeeRoles> employeeRoles = new HashSet<>();

    @ManyToMany
    @JoinTable(name="projectStages_tasks",
            joinColumns = @JoinColumn(name="projectStages_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="tasks_id", referencedColumnName="id")
    )
    private Set<Tasks> tasks = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String description;

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
