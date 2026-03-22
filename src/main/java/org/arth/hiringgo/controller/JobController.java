package org.arth.hiringgo.controller;

import org.arth.hiringgo.model.JobPost;
import org.arth.hiringgo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin( origins = "http://localhost:3000")
public class JobController {

    private JobService jobService;

    @GetMapping("/jobposts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/jobpost/{postId}")
    public JobPost getJobPost(@PathVariable int postId) {
        return jobService.getJobPost(postId);
    }

    @PostMapping("/jobpost")
    public JobPost addJobPost(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobService.getJobPost(jobPost.getPostId());
    }
    @PutMapping("/jobpost")
    public JobPost updateJobPost(@RequestBody JobPost jobPost) {
        jobService.updateJobPost(jobPost);
        return jobService.getJobPost(jobPost.getPostId());
    }
    @DeleteMapping("/jobpost/{id}")
    public void deleteJobPost(@PathVariable("id") int postId) {
        jobService.deleteJobPost(postId);

    }
    @GetMapping("/load")
    public String loadDB() {
        List<JobPost> saved = jobService.loadDB();

        return saved.isEmpty() ? "Loading Failed!" : "Loading Successful!";
    }

    @GetMapping("/jobposts/{keyword}")
    public List<JobPost> searchByKeyword(@PathVariable String keyword) {

        return jobService.searchByKeyword(keyword);
    }



    @Autowired
    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }
}
