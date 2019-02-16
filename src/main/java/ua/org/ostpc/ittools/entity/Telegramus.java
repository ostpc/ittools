package ua.org.ostpc.ittools.entity;

import javax.persistence.*;


@Entity
@Table(name = "TELEGRAM")
public class Telegramus {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Sequence?
    private long id;


    @Column(name = "USERNAME")
    private String username;

    @Column(name = "TELEGRAMNAME", nullable = false)
    private String telegramname;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelegramname() {
        return telegramname;
    }

    public void setTelegramname(String telegramname) {
        this.telegramname = telegramname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
