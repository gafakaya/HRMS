import axios from "axios";

export default class SchoolService {
  constructor() {
    this.apiUrl = "http://localhost:8080/api/schoolsController/";
  }

  getSchools() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  add(school) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
