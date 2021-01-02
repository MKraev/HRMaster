package com.ehrsystem.hr.repositories;

import com.ehrsystem.hr.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface JobPostRepository extends JpaRepository<JobPost, Long> {
    JobPost findById(String id);

    @Query(value="Select * from job_post j where j.title like %:keyword% or j.description like %:keyword%"
           , nativeQuery = true)
    Set<JobPost> findByKeyword(@Param("keyword") String keyword);
}
