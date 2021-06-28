import axios from "axios";

export default class ResumeDetailService {
  constructor() {
    this.apiUrl = "http://localhost:8080/api/cvDetailsController/";
  }

  getResumeDetailByJobSeekerId(jobSeekerId) {
    return axios.get(
      `${this.apiUrl}getByJobSeeker_id?jobSeeker=${jobSeekerId}`
    );
  }

  //  TODO: add()

  add(resumeDetail) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
