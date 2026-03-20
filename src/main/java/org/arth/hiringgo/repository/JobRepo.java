package org.arth.hiringgo.repository;

import org.arth.hiringgo.model.JobPost;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class JobRepo {

    private final List<JobPost> jobs = new ArrayList<>(Arrays.asList(
            new JobPost(1, "React developer", "An experienced frontend dev is required. 0-2 years of experience!", 2, List.of("Javascript", "Typescript")),
            new JobPost(2, "Angular developer", "An experienced frontend dev is required. 0-2 years of experience!", 2, List.of("Javascript", "Typescript")),
            new JobPost(3, "Python Developer", "An experienced python dev is required. 0-2 years of experience!", 2, List.of("PyTorch")),
            new JobPost(4, "SQL developer", "An experienced database admin is required. 0-1 years of experience!", 1, List.of("GraphQL", "Unity"))
    ));

    private Optional<JobPost> getJobPostById(int postId) {
        return this.jobs.stream().filter((jPost) -> jPost.getPostId() == postId ).findFirst();
    }
    public void addJob(JobPost jobPost) {
        jobs.add(jobPost);
    }

    public List<JobPost> getAllJobs() {

        return jobs;
    }

    public JobPost getJobPost(int postId) {
        Optional<JobPost> jobPost = getJobPostById(postId);

        return jobPost.orElse(null);

    }

    public void updateJobPost(JobPost jobPost) {
        Optional<JobPost> jobPosFound = getJobPostById(jobPost.getPostId());
        if(jobPosFound.isEmpty()) {
            addJob(jobPost);
        } else {
            JobPost updatedJobPost = jobPosFound.get();
            updatedJobPost.setPostDesc(jobPost.getPostDesc());
            updatedJobPost.setPostProfile(jobPost.getPostProfile());
            updatedJobPost.setReqExperience(jobPost.getReqExperience());
            updatedJobPost.setPostTechStack(jobPost.getPostTechStack());
        }
    }


    public String deleteJobPost(int postId) {
        Optional<JobPost> jobPosFound = getJobPostById(postId);
        if(jobPosFound.isEmpty()) {
            return "No Entity with Id: " + postId + " found!";
        } else {
            jobs.remove(jobPosFound.get());
            return "Deleted Entity with Id: "+postId+" successfully!";
        }
    }
}
