package kodlama.io.hrms2.business.abstracts;

import java.util.List;

import kodlama.io.hrms2.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
}
