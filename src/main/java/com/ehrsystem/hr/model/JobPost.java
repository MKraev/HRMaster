package com.ehrsystem.hr.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String requirement;
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    private User poster;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jobPost")
    private Set<JobSkill> jobSkills = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "jobpost_user",
            joinColumns = @JoinColumn(name = "jobpost_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> usersApplied;

    public JobPost() {
    }

    public JobPost(String title, String description, String requirement, String city, User poster,
                   Set<JobSkill> jobSkills, Set<User> usersApplied) {
        this.title = title;
        this.description = description;
        this.requirement = requirement;
        this.city = city;
        this.poster = poster;
        this.jobSkills = jobSkills;
        this.usersApplied = usersApplied;
    }

    public JobPost(String title, String description, String requirement, String city, User poster) {
        this.title = title;
        this.description = description;
        this.requirement = requirement;
        this.city = city;
        this.poster = poster;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public Set<JobSkill> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(Set<JobSkill> jobSkills) {
        this.jobSkills = jobSkills;
    }

    public Set<User> getUsersApplied() {
        return usersApplied;
    }

    public void setUsersApplied(Set<User> usersApplied) {
        this.usersApplied = usersApplied;
    }

    public JobPost addJobSkill(JobSkill jobSkill){
        jobSkill.setJobPost(this);
        this.jobSkills.add(jobSkill);
        return this;
    }
}
