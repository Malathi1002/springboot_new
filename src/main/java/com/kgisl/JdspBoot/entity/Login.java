package com.kgisl.JdspBoot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    protected String Name;
    protected long MobileNumber;

    public String getName() {
        return Name;
    }

    public void Name(String Name) {
        this.Name = Name;
    }

    public long getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(long MobileNumber) {
        this.MobileNumber = MobileNumber;
    }
    
}
