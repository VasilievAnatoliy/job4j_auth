package ru.job4j.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Модель данных - сотрудник компании
 */
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private long inn;
    private Timestamp hired = new Timestamp(System.currentTimeMillis());
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(name = "employee_person", joinColumns = {
            @JoinColumn(name = "employee_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "person_id", nullable = false, updatable = false)})
    private List<Person> account = new ArrayList<>();



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public Timestamp getHired() {
        return hired;
    }

    public void setHired(Timestamp hired) {
        this.hired = hired;
    }

    public List<Person> getAccount() {
        return account;
    }

    public void setAccount(List<Person> account) {
        this.account = account;
    }
}
