import axios from "axios";

export default class JobSeekerService {
  constructor() {
    this.apiUrl = "http://localhost:8080/api/jobSeekersController/";
  }

  getall() {
    return axios.get(`${this.apiUrl}getall`);
  }

  getById(jobSeekerId) {
    return axios.get(`${this.apiUrl}getById?jobSeekerId=${jobSeekerId}`);
  }


  getJobSeekerResumeByJobSeekerId(jobSeekerId) {
    return axios.get(`${this.apiUrl}getJobSeekerResumeByJobSeekerId?jobSeekerId=${jobSeekerId}`);
  }

  update(jobSeekerId, jobSeeker) {
    return axios.put(`${this.apiUrl}/update?jobSeekerId=${jobSeekerId}`, jobSeeker);
  }
}
