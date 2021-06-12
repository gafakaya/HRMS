import axios from "axios";

export default class JobTitleService {
  constructor() {
    this.apiUrl =
      "http://localhost:8080/api/jobTitlesController/";
  }

  getJobTitles() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  add(jobTitle) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
