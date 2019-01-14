package com.hwj.banking.entity;

import javax.persistence.*;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_DET_ID")
    private int id;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "CELEPHONE")
    private String celephone;
    @Column(name = "REMARK")
    private String remark;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "USR_ID")
    private User user;

    public UserDetail() {
    }

    public UserDetail(String email, String celephone, String remark) {
        this.email = email;
        this.celephone = celephone;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelephone() {
        return celephone;
    }

    public void setCelephone(String celephone) {
        this.celephone = celephone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
