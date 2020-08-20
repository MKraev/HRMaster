package com.ehrsystem.hr.commands;

public class UserSkillCommand {

    private Long userSkillId;
    private Long thisUserId;
    private String userSkillName;
    private int userSkillLevel;

    public Long getUserSkillId() {
        return userSkillId;
    }

    public void setUserSkillId(Long userSkillId) {
        this.userSkillId = userSkillId;
    }

    public Long getThisUserId() {
        return thisUserId;
    }

    public void setThisUserId(Long thisUserId) {
        this.thisUserId = thisUserId;
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
}
