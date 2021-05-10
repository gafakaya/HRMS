package kodlama.io.hrms2.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms2.business.abstracts.JobTitleService;
import kodlama.io.hrms2.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/job-titles")
public class JobTitlesControllers {

	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesControllers(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("/getall")
	public List<JobTitle> getAll(){
		return this.jobTitleService.getAll();
	}
	
}
