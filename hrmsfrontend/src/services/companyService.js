import axios from "axios";

export default class CompanyService {
  constructor() {
    this.apiUrl = "http://localhost:8080/api/companies/";
  }

  getCompanies() {
    return axios.get(`${this.apiUrl}getAll`);
  }
}
