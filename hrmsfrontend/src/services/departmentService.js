import axios from "axios";

export default class DepartmentService {
  constructor() {
    this.apiUrl = "http://localhost:8080/api/departmentsController/";
  }

  getDeparments() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  add(department) {
    return axios.post(`${this.apiUrl}add`, {
      departmentName: department.departmentName,
    });
  }
}
