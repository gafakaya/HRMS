import axios from "axios";

export default class JobAdvertisementApplicationService {
  constructor() {
    this.apiUrl =
      "http://localhost:8080/api/jobAdvertisementApplicationsController/";
  }

  getJobAdvertisementApplications() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  add(jobAdvertisementApplication) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
