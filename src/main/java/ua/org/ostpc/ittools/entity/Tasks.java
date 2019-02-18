package ua.org.ostpc.ittools.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tasks {

/*    @ManyToOne
    @JoinColumn(name="tasks_id", nullable=false)
    private Set<Project> project = new HashSet<>(); //если работать не будет то переделать, как ниже с HashSet*/

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="tasks_id")
    private Project project;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tasks")
    private Set<ProjectStages> projectStages = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "tasks")
    private Set<Employees> employees = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
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

    public Set<ProjectStages> getProjectStages() {
        return projectStages;
    }

    public void setProjectStages(Set<ProjectStages> projectStages) {
        this.projectStages = projectStages;
    }


    public Set<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employees> employees) {
        this.employees = employees;
    }

/*    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }*/

}
