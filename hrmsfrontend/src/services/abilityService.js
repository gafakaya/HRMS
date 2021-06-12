import axios from "axios";

export default class AbilityService {
  constructor() {
    this.apiUrl = "http://localhost:8080/api/abilitiesController/";
  }

  getAbilities() {
    return axios.get(`${this.apiUrl}getAll`);
  }

  add(ability) {
    return axios.post(`${this.apiUrl}add`, {
      abilityName: ability.abilityName,
    });
  }
}
