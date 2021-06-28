import axios from "axios";

export default class JobSeekerSchoolService {
  constructor() {
    this.apiUrl =
      "http://localhost:8080/api/jobSeekerSchoolDepartmentsController/";
  }

  getJobSeekerSchools() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  getJobSeekerSchoolsByJobSeekerId(jobSeekerId) {
    return axios.get(`${this.apiUrl}getByJobSeeker_jobSeekerIdOrderByDateOfGraduation?jobSeekerId=${jobSeekerId}`);
  }

  add(jobSeekerSchool) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
