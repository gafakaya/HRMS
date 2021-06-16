import React from "react";
import "../styles/SidebarOption.css";

function SidebarOption({ Icon, title }) {
  return (
    <div className="sidebarOption">
      {Icon && <Icon className="sidebarOption__icon" />}
      <b className="sidebarOption__title">{title}</b>
    </div>
  );
}

export default SidebarOption;
