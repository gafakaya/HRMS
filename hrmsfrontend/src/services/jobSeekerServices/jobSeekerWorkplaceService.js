import axios from "axios";

export default class JobSeekerWorkplaceService {
  constructor() {
    this.apiUrl =
      "http://localhost:8080/api/jobSeekerWorkplaceTitlesController/";
  }

  getJobSeekerWorkplaces() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  getJobSeekerWorkplacesByJobSeekerId(jobSeekerId) {
    return axios.get(`${this.apiUrl}getByJobSeeker_id?jobSeekerId=${jobSeekerId}`);
  }

  add(jobSeekerWorkplace) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
