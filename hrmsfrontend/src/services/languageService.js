import axios from "axios";

export default class LanguageService {
  constructor() {
    this.apiUrl = "http://localhost:8080/api/languagesController/";
  }

  getLanguages() {
    return axios.get(`${this.apiUrl}getAll`);
  }

//   add(language) {
//     return axios.post(`${this.apiUrl}add`, {});
//   }
}
