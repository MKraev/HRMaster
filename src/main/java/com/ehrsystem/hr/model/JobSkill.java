package com.ehrsystem.hr.model;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(exclude = {"jobPost"})
@Entity
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skillName;
    private int skillLevel;

    @ManyToOne
    private JobPost jobPost;

    public JobSkill() {
    }

    public JobSkill(String skillName, int skillLevel, JobPost jobPost) {
        this.skillName = skillName;
        this.skillLevel = skillLevel;
        this.jobPost = jobPost;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
