package com.ehrsystem.hr.config;

import com.ehrsystem.hr.model.JobPost;
import com.ehrsystem.hr.model.JobSkill;
import com.ehrsystem.hr.model.User;
import com.ehrsystem.hr.model.UserSkill;
import com.ehrsystem.hr.repositories.JobPostRepository;
import com.ehrsystem.hr.repositories.JobSkillRepository;
import com.ehrsystem.hr.repositories.UserRepository;
import com.ehrsystem.hr.repositories.UserSkillRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        User teo = new User("teo","password1","Teodor","Petrov",
                "Data Analyst","senior","active","teo@gmail.com","jobSeeker"," ","Sofia");
        User rado = new User("rado","password2","Radoslav","Yosifov",
                "Charting specialist","middle","active","rado@gmail.com","jobSeeker"," ","Sofia");
        User vili = new User("vili","password3","Violeta","Genova","Platfor lead","senior","active","vili@gmail.com","jobSeeker"," ","Sofia");
        User viki = new User("viki","password4","Viktoria","Stoicheva","QA","junior","active","viki@gmail.com","jobSeeker"," ","Sofia");
        User toni = new User("toni","password5","Anton","Manev","recruiter","junior","active","toni@gmail.com","jobSeeker"," ","Sofia");
        User toli = new User("toli","password6","Anatoli","Toshev","QA","manager","active","toli@gmail.com","jobSeeker"," ","Sofia");
        User petko = new User("petko","password7","Petko","Georgiev","Project manager","senior","active","petko@gmail.com","jobSeeker"," ","Sofia");
        User zlati = new User("zlati","password8","Zlatka","Petkova","Project manager","manager","active","zlati@gmail.com","jobSeeker"," ","Sofia");
        User milen = new User("milen","password9","Milen","Kraev","Business analyst","senior","active","milen@gmail.com","jobSeeker"," ","Sofia");
        User zdravo = new User("zdravo","password10","Zdravko","Ivanov","Management","director","active","zdravo@gmail.com","jobSeeker"," ","Sofia");


        JobPost javaDev = new JobPost("Java Developer","Develop java applications",
                "To be smart and experienced","Sofia",ivan81);
        JobPost jobPosted1 = new JobPost("QA","Test a code","Experiansed QA with good history of qa","Sofia",toni);
        JobPost jobPosted2 = new JobPost("Developer","Write a code","A lot of code on a daily basis","Sofia",toni);
        JobPost jobPosted3 = new JobPost("Project manager","Manage projects","Worked In many projects and stakeholders","Sofia",toni);
        JobPost jobPosted4 = new JobPost("Office assistant","Manage the office","New graduate with ability to maintaince order","Sofia",toni);
        JobPost jobPosted5 = new JobPost("Managing director","Manage the company","Over 20 years of experience in corporate environment","Sofia",toni);
        JobPost jobPosted6 = new JobPost("HR","Hire staff","Some experience in headhunting","Sofia",toni);
        JobPost jobPosted7 = new JobPost("Web Designer","Designe pages","Art person with good numeric skills","Sofia",toni);
        JobPost jobPosted8 = new JobPost("Business analyst","Analyse the business","Multiple business experience","Sofia",toni);
        JobPost jobPosted9 = new JobPost("Data Base developer","Develop databases","Develop complec databases","Sofia",toni);


        ivan81.getJobPosted().add(javaDev);
        toni.getJobPosted().add(jobPosted1);
        toni.getJobPosted().add(jobPosted2);
        toni.getJobPosted().add(jobPosted3);
        toni.getJobPosted().add(jobPosted4);
        toni.getJobPosted().add(jobPosted5);
        toni.getJobPosted().add(jobPosted6);
        toni.getJobPosted().add(jobPosted7);
        toni.getJobPosted().add(jobPosted8);
        toni.getJobPosted().add(jobPosted9);

        JobSkill java = new JobSkill("Java",8,javaDev);

        UserSkill javaU = new UserSkill("Java",6,ivan81);

        javaDev.getJobSkills().add(java);
        ivan81.getUserSkills().add(javaU);


        userRepository.save(ivan81);
        userRepository.save(teo);
        userRepository.save(rado);
        userRepository.save(vili);
        userRepository.save(viki);
        userRepository.save(toni);
        userRepository.save(toli);
        userRepository.save(petko);
        userRepository.save(zlati);
        userRepository.save(milen);
        userRepository.save(zdravo);

        jobPostRepository.save(javaDev);
        jobPostRepository.save(jobPosted1);
        jobPostRepository.save(jobPosted2);
        jobPostRepository.save(jobPosted3);
        jobPostRepository.save(jobPosted4);
        jobPostRepository.save(jobPosted5);
        jobPostRepository.save(jobPosted6);
        jobPostRepository.save(jobPosted7);
        jobPostRepository.save(jobPosted8);
        jobPostRepository.save(jobPosted9);


        jobSkillRepository.save(java);
        userSkillRepository.save(javaU);
    }
}
