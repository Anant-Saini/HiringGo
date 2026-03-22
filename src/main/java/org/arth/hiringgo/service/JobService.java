package org.arth.hiringgo.service;

import org.arth.hiringgo.model.JobPost;
import org.arth.hiringgo.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    private JobRepo jobRepo;

    public void addJob(JobPost jobPost) {

        jobRepo.save(jobPost);
    }

    public List<JobPost> getAllJobs() {

        return jobRepo.findAll();
    }

    public JobPost getJobPost(int postId) {
        return jobRepo.findById(postId).orElse(new JobPost());
    }

    public void updateJobPost(JobPost jobPost) {
        jobRepo.save(jobPost);
    }

    public void deleteJobPost(int postId) {
        jobRepo.deleteById(postId);
    }

    public List<JobPost> searchByKeyword(String keyword) {
        return jobRepo.findByPostDescContainingIgnoreCaseOrPostProfileContainingIgnoreCase(keyword, keyword);
    }

    public List<JobPost> loadDB() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(1, "React developer", "An experienced frontend dev is required. 0-2 years of experience!", 2, List.of("Javascript", "Typescript")),
                new JobPost(2, "Angular developer", "An experienced frontend dev is required. 0-2 years of experience!", 2, List.of("Javascript", "Typescript")),
                new JobPost(3, "Python Developer", "An experienced python dev is required. 0-2 years of experience!", 2, List.of("PyTorch")),
                new JobPost(4, "SQL developer", "An experienced database admin is required. 0-1 years of experience!", 1, List.of("GraphQL", "Unity")),
                new JobPost(5, "AI/ML developer", "An experienced machine learning engineer is required. 0-3 years of experience!", 1, List.of("GraphQL", "Unity"))
        ));
       return jobRepo.saveAll(jobs);
    }

    @Autowired
    public void setJobRepo(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }



}
