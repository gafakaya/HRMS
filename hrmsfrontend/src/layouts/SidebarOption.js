import React from "react";
import "../styles/SidebarOption.css";

function SidebarOption({ Icon, title }) {
  return (
    <div className="sidebarOption">
      {Icon && <Icon className="sidebarOption__icon" />}
      <h3 className="sidebarOption__title">{title}</h3>
    </div>
  );
}

export default SidebarOption;
