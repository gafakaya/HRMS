import React from "react";
import "../styles/HeaderOption.css";

function HeaderOption({Icon, title}) {
  return (
    <div className="headerOption">
      {Icon && <Icon />}
      <b className="headerOption__title">{title}</b>
    </div>
  );
}

export default HeaderOption;
