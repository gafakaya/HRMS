import axios from "axios";

export default class JobSeekerLanguageService{
  constructor() {
    this.apiUrl =
      "http://localhost:8080/api/jobSeekerLanguagesController/";
  }

  getJobSeekerLanguages() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  getJobSeekerLanguagesByJobSeekerId(jobSeekerId) {
    return axios.get(`${this.apiUrl}getByJobSeeker_id?jobSeekerId=${jobSeekerId}`);
  }

  add(jobSeekerLanguage) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
