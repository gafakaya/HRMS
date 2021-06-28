import React from "react";
import { useHistory } from "react-router-dom";
import "../styles/HeaderOption.css";

function HeaderOption({ Icon, title, path }) {
  const history = useHistory();

  const openProfileSection = (path) => {
    history.push(path);
  };
  return (
    <div onClick={() => openProfileSection(path)} className="headerOption">
      {Icon && <Icon />}
      <b className="headerOption__title">{title}</b>
    </div>
  );
}

export default HeaderOption;
