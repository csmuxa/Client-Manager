package com.task.testTask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "managers")
public class Manager {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL,targetEntity = Manager.class)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Manager deputy;

    @OneToMany(mappedBy = "manager",cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Client> clients;


    @JsonIgnore
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Manager getDeputy() {
        return deputy;
    }

    public void setDeputy(Manager deputy) {
        this.deputy = deputy;
    }
}
