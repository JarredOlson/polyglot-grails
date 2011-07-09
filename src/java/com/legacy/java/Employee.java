package com.legacy.java;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    String name;
    Double hourlyWage;
    Long uniqueIdentifier;

    public Employee() {

    }

    public Long getId() {
        return this.uniqueIdentifier;
    }

    public void setId(Long id) {
        this.uniqueIdentifier = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "HOURLY_WAGE")
    public Double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(Double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    @Id
    @Column(name = "UNIQUE_ID")
    @GeneratedValue
    public Long getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(Long uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }

}
