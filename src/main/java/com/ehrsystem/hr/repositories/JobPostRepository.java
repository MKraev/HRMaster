package com.ehrsystem.hr.repositories;

import com.ehrsystem.hr.model.JobPost;
import org.springframework.data.repository.CrudRepository;

public interface JobPostRepository extends CrudRepository<JobPost, Long> {
}
