package ua.org.ostpc.ittools.entity;

import javax.persistence.*;

@Entity
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String mobilePhone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    private String resumePath;

    @Column(nullable = false)
    private String formPath;

    //Getters an setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getResumePath() {
        return resumePath;
    }

    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }

    public String getFormPath() {
        return formPath;
    }

    public void setFormPath(String formPath) {
        this.formPath = formPath;
    }
}
