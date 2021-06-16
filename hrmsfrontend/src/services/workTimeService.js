import axios from "axios";

export default class WorkTimeService {
  constructor() {
    this.apiUrl =
    "http://localhost:8080/api/workTimeController/";
  }

  getWorkTimes() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  getWorkTimesById(workTimeId) {
    return axios.get(`${this.apiUrl}getById?workTimeId=${workTimeId}`);
  }

  add(workTime) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
