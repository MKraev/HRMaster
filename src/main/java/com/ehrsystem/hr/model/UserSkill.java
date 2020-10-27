package com.ehrsystem.hr.model;

import javax.persistence.*;

@Entity
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userSkillName;
    private int userSkillLevel;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public UserSkill() {
    }

    public UserSkill(String userSkillName, int userSkillLevel, User user) {
        this.userSkillName = userSkillName;
        this.userSkillLevel = userSkillLevel;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserSkillName() {
        return userSkillName;
    }

    public void setUserSkillName(String userSkillName) {
        this.userSkillName = userSkillName;
    }

    public int getUserSkillLevel() {
        return userSkillLevel;
    }

    public void setUserSkillLevel(int userSkillLevel) {
        this.userSkillLevel = userSkillLevel;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
