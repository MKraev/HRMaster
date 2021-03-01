package com.ehrsystem.hr.commands;

import com.ehrsystem.hr.model.User;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
public class JobPostCommand {

    private Long id;
    private String title;
    private String description;
    private String requirement;
    private String city;
    private User poster;
    private Set<JobSkillCommand> jobSkills  = new HashSet<>();
    private Set<User> usersApplied;

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

    public Set<JobSkillCommand> getJobSkills() {
        return jobSkills;
    }

    public void setJobSkills(Set<JobSkillCommand> jobSkills) {
        this.jobSkills = jobSkills;
    }

    public Set<User> getUsersApplied() {
        return usersApplied;
    }

    public void setUsersApplied(Set<User> usersApplied) {
        this.usersApplied = usersApplied;
    }
}
