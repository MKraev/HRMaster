package com.ehrsystem.hr.config;

import com.ehrsystem.hr.model.JobPost;
import com.ehrsystem.hr.model.JobSkill;
import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.repositories.JobPostRepository;
import com.ehrsystem.hr.repositories.JobSkillRepository;
import com.ehrsystem.hr.repositories.UserRepository;
import com.ehrsystem.hr.repositories.UserSkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BootStrapH2Data implements CommandLineRunner {

    private final UserRepository userRepository;
    private final JobPostRepository jobPostRepository;
    private final UserSkillRepository userSkillRepository;
    private final JobSkillRepository jobSkillRepository;

    public BootStrapH2Data(UserRepository userRepository, JobPostRepository jobPostRepository,
                           UserSkillRepository userSkillRepository, JobSkillRepository jobSkillRepository) {
        this.userRepository = userRepository;
        this.jobPostRepository = jobPostRepository;
        this.userSkillRepository = userSkillRepository;
        this.jobSkillRepository = jobSkillRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        User ivan81 = new User("ivan81","password","Ivan","Ivanov",
                "Java developer","Senior","active","ivan@gmail.com","recruiter",
                "Find the best talents in the city","Sofia");

        JobPost javaDev = new JobPost("Java Developer","Develop java applications",
                "To be smart and experienced","Sofia",ivan81);

        ivan81.getJobPosted().add(javaDev);

        JobSkill java = new JobSkill("Java",8,javaDev);

        javaDev.getJobSkills().add(java);

        userRepository.save(ivan81);
        jobPostRepository.save(javaDev);
        jobSkillRepository.save(java);
    }
}
