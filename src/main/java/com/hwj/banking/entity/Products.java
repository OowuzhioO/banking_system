package com.hwj.banking.entity;

public class Products {

    private int id;
    private String pName;
    private long balance;

    public Products() {
    }

    public Products(String pName, long balance) {
        this.pName = pName;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
