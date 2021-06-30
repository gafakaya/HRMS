import axios from "axios";
export default class LanguageLevelService {
  constructor() {
    this.apiUrl =
      "http://localhost:8080/api/languageLevelsController/";
  }

  getLanguageLevels() {
    return axios.get(`${this.apiUrl}getAll`);
  }

//   add(languageLevel) {
//     return axios.post(`${this.apiUrl}add`, {});
//   }
}
