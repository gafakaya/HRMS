import axios from "axios";

export default class JobSeekerPhotoService {
  constructor() {
    this.apiUrl =
      "http://localhost:8080/api/jobSeekerPhotosController/";
  }

  getJobSeekerPhotos() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  getJobSeekerPhotosByJobSeekerId(jobSeekerId) {
    return axios.get(`${this.apiUrl}getByJobSeeker_id?jobSeekerId=${jobSeekerId}`);
  }

  add(jobSeekerPhoto) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
