import axios from "axios";

export default class JobSeekerAbilityService {
  constructor() {
    this.apiUrl =
      "http://localhost:8080/api/jobSeekerAbilitiesController/";
  }

  getJobSeekerAbilities() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  getJobSeekerAbilitiesByJobSeekerId(jobSeekerId) {
    return axios.get(`${this.apiUrl}getByJobSeeker_id?jobSeekerId=${jobSeekerId}`);
  }

  add(jobSeekerAbility) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
