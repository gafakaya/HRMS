import axios from "axios";

export default class JobAdvertisementCommentService {
  constructor() {
    this.apiUrl =
      "http://localhost:8080/api/jobAdvertisementCommentsController/";
  }

  getJobAdvertisementComments() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  add(jobAdvertisementComment) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
