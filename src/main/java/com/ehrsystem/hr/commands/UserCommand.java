package com.ehrsystem.hr.commands;

import com.ehrsystem.hr.model.JobPost;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;


public class UserCommand {

    private Long userID;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String userName;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String password;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String lastName;

    private String jobTitle;
    private String seniorityLevel;
    private String status;
    private String emailUser;
    private String userType;
    private String resume;
    private String city;

    private Set<UserSkillCommand> userSkills;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<UserSkillCommand> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(Set<UserSkillCommand> userSkills) {
        this.userSkills = userSkills;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
