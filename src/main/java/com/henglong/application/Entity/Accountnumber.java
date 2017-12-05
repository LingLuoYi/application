package com.henglong.application.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Accountnumber {
    @Id
    @GeneratedValue
    private Integer ID;
    private String AccountNumber;
    private String Bank;
    private String AccountOpening;

    public void Accountnumber(){}

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public String getAccountOpening() {
        return AccountOpening;
    }

    public void setAccountOpening(String accountOpening) {
        AccountOpening = accountOpening;
    }
}
