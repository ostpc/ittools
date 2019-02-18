package ua.org.ostpc.ittools.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EmployeeRoles {


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "employeeRoles")
    private Set<Employees> employees = new HashSet<>();


    @ManyToMany
    @JoinTable(name="employeeRoles_projectStages",
            joinColumns = @JoinColumn(name="employeeRoles_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="projectStages_id", referencedColumnName="id")
    )
    private Set<ProjectStages> projectStages = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String title;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /*
        public Set<Employees> getEmployees() {
            return employees;
        }

        public void setEmployees(Set<Employees> employees) {
            this.employees = employees;
        }

    */
    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }


    public Set<ProjectStages> getProjectStages() {
        return projectStages;
    }

    public void setProjectStages(Set<ProjectStages> projectStages) {
        this.projectStages = projectStages;
    }


}
