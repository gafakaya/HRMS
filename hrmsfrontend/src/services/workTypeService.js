import axios from "axios";

export default class WorkTypeService {
  constructor() {
    this.apiUrl =
    "http://localhost:8080/api/workTypeController/";
  }

  getWorkTypes() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  getWorkTypesById(workTypeId) {
    return axios.get(`${this.apiUrl}getById?workTypeId=${workTypeId}`);
  }

  add(workType) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
