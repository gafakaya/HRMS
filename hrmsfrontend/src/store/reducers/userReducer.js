import { LOGIN, LOGOUT } from "../actions/userAction";
import { user } from "../initialValues/user";

const initialState = {
  user: user,
};

export default function userReducer(state = initialState, { type, payload }) {
  switch (type) {
    case LOGIN:
      break;
    case LOGOUT:
      break;

    default:
      break;
  }
}
