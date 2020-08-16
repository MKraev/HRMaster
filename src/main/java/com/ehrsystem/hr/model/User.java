package com.ehrsystem.hr.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;


    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String seniorityLevel;
    private String status;
    private String emailUser;
    private String userType;
    private String resume;
    private String city;

    @Lob
    private Byte[] image;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<UserSkill> userSkills = new HashSet<>();


    @OneToMany(cascade = CascadeType.ALL)
    private Set<JobPost> jobPosted  = new HashSet<>();

    @ManyToMany
    private Set<JobPost> jobApplied;

    public Set<JobPost> getJobPosted() {
        return jobPosted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setJobPosted(Set<JobPost> jobPosted) {
        this.jobPosted = jobPosted;
    }

    public Set<JobPost> getJobApplied() {
        return jobApplied;
    }

    public void setJobApplied(Set<JobPost> jobApplied) {
        this.jobApplied = jobApplied;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Set<UserSkill> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(Set<UserSkill> userSkills) {
        this.userSkills = userSkills;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSeniorityLevel() {
        return seniorityLevel;
    }

    public void setSeniorityLevel(String seniorityLevel) {
        this.seniorityLevel = seniorityLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User addUserSkill(UserSkill userSkill){
        userSkill.setUser(this);
        this.userSkills.add(userSkill);
        return this;
    }
}
