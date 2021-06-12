import axios from "axios";

export default class EventService {
  constructor() {
    this.apiUrl = "http://localhost:8080/api/eventsController/";
  }

  getEvents() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  getEventsOrderByCreatedAt() {
    return axios.get(`${this.apiUrl}getOrderByCreatedAt`);
  }

  getEventsOrderByDateOfEvent() {
    return axios.get(`${this.apiUrl}getOrderByDateOfEvent`);
  }

  getEventsOrderByDateOfEventPaged() {
    return axios.get(`${this.apiUrl}getOrderByDateOfEventAscPage?pageNo=1&pageSize=5`);
  }

  getEventsByCompanyIdOrderByDateOfEvent(companyId) {
    return axios.get(
      `${this.apiUrl}getByCompanyidOrderByDateOfEventAsc?companyId=${companyId}`
    );
  }

  add(event) {
    return axios.post(`${this.apiUrl}add`, {});
  }
}
