import React from "react";
import "../styles/HeaderOption.css";

function HeaderOption({Icon, title}) {
  return (
    <div className="headerOption">
      {Icon && <Icon />}
      <h4>{title}</h4>
    </div>
  );
}

export default HeaderOption;
