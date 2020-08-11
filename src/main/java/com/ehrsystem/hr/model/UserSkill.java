package com.ehrsystem.hr.model;

import javax.persistence.*;

@Entity
public class UserSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String userSkillName;
    private int userSkillLevel;

    @ManyToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
