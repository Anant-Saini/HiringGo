package org.arth.hiringgo.repository;

import org.arth.hiringgo.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByPostDescContainingIgnoreCaseOrPostProfileContainingIgnoreCase(String postDesc, String postProfile);

}


//private Optional<JobPost> getJobPostById(int postId) {
//    return this.jobs.stream().filter((jPost) -> jPost.getPostId() == postId ).findFirst();
//}
//public void addJob(JobPost jobPost) {
//    jobs.add(jobPost);
//}
//
//public List<JobPost> getAllJobs() {
//
//    return jobs;
//}
//
//public JobPost getJobPost(int postId) {
//    Optional<JobPost> jobPost = getJobPostById(postId);
//
//    return jobPost.orElse(null);
//
//}
//
//public void updateJobPost(JobPost jobPost) {
//    Optional<JobPost> jobPosFound = getJobPostById(jobPost.getPostId());
//    if(jobPosFound.isEmpty()) {
//        addJob(jobPost);
//    } else {
//        JobPost updatedJobPost = jobPosFound.get();
//        updatedJobPost.setPostDesc(jobPost.getPostDesc());
//        updatedJobPost.setPostProfile(jobPost.getPostProfile());
//        updatedJobPost.setReqExperience(jobPost.getReqExperience());
//        updatedJobPost.setPostTechStack(jobPost.getPostTechStack());
//    }
//}
//
//
//public String deleteJobPost(int postId) {
//    Optional<JobPost> jobPosFound = getJobPostById(postId);
//    if(jobPosFound.isEmpty()) {
//        return "No Entity with Id: " + postId + " found!";
//    } else {
//        jobs.remove(jobPosFound.get());
//        return "Deleted Entity with Id: "+postId+" successfully!";
//    }
//}