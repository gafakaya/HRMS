import axios from "axios";

export default class SocialMediaService {
  constructor() {
    this.apiUrl = "http://localhost:8080/api/socialMediasController/";
  }

  getAll() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  getByJobSeekerId(jobSeekerId) {
    return axios.get(
      `${this.apiUrl}getByJobSeeker_id?jobSeekerId=${jobSeekerId}`
    );
  }

  add(socialMedia) {
    return axios.post(`${this.apiUrl}add`, socialMedia);
  }

  update(socialMedia) {
    return axios.post(`${this.apiUrl}add`, socialMedia);
  }
}
