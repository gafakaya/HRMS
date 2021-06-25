import axios from "axios";

export default class JobAdvertisementService {
  constructor() {
    this.apiUrl = "http://localhost:8080/api/jobAdvertisements/";
  }

  getJobAdvertisements() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  getJobAdvertisementsByEnable() {
    return axios.get(`${this.apiUrl}getByEnable`);
  }

  getJobAdvertisementsByEnableAndCompanyName(companyName) {
    return axios.get(`${this.apiUrl}getByEnableAndCompany_companyName?companyName=${companyName}`);
  }

  getJobAdvertisementsByEnablePage(pageNo, pageSize) {
    return axios.get(`${this.apiUrl}getByEnablePage?pageNo=${pageNo}&pageSize=${pageSize}`);
  }

  getJobAdvertisementsByEnableSortedAsc() {
    return axios.get(`${this.apiUrl}getByEnableSortedAsc`);
  }

  getJobAdvertisementsByEnableSortedDesc() {
    return axios.get(`${this.apiUrl}getByEnableSortedDesc`);
  }

  getJobAdvertisementsWithCompany() {
    return axios.get(`${this.apiUrl}getJobAdvertisementWithCompany`);
  }

  getJobAdvertisementsWithCompanyOrderByCreatedAt() {
    return axios.get(`${this.apiUrl}getJobAdvertisementWithCompanyOrderByCreatedAt`);
  }

  add(jobAdvertisement) {
    axios.post(`${this.apiUrl}add`, jobAdvertisement);
  }

  update(jobAdvertisementId, jobAdvertisement) {
    axios.put(`${this.apiUrl}update?jobAdvertisemenetId=${jobAdvertisementId}`, jobAdvertisement)
  }

  confirmation(jobAdvertisementId, confirm) {
    axios.put(`${this.apiUrl}confirmation?confirm=${confirm}&jobAdvertisemenetId=${jobAdvertisementId}`)
  }

}
