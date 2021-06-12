import axios from "axios";

export default class SchoolDepartmentService {
  constructor() {
    this.apiUrl =
      "http://localhost:8080/api/schoolDepartmentsController/";
  }

  getSchoolDepartments() {
    return axios.get(`${this.apiUrl}getAll`);
  }

//   add(schoolDepartment) {
//     return axios.post(`${this.apiUrl}add`, {});
//   }
}
