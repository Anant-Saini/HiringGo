package org.arth.hiringgo.service;

import org.arth.hiringgo.model.JobPost;
import org.arth.hiringgo.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {


    private JobRepo jobRepo;

    public void addJob(JobPost jobPost) {
        jobRepo.addJob(jobPost);
    }

    public List<JobPost> getAllJobs() {
        return jobRepo.getAllJobs();
    }

    public JobPost getJobPost(int postId) {
        return jobRepo.getJobPost(postId);
    }

    @Autowired
    public void setJobRepo(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public void updateJobPost(JobPost jobPost) {
        jobRepo.updateJobPost(jobPost);
    }

    public String deleteJobPost(int postId) {
        return jobRepo.deleteJobPost(postId);
    }
}
