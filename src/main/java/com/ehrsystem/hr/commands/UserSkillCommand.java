package com.ehrsystem.hr.commands;

public class UserSkillCommand {

    private Long userSkillId;
    private Long userId;
    private String skillName;
    private int skillLevel;

    public Long getUserSkillId() {
        return userSkillId;
    }

    public void setUserSkillId(Long userSkillId) {
        this.userSkillId = userSkillId;
    }

    public Long getJobPostId() {
        return userId;
    }

    public void setJobPostId(Long jobPostId) {
        this.userId = jobPostId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setUserId(Long userId) {
    }
}