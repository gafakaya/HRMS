import React from "react";
import "../styles/Sidebar.css";
import SidebarOption from "./SidebarOption";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import BusinessCenterIcon from "@material-ui/icons/BusinessCenter";
import BusinessIcon from "@material-ui/icons/Business";
import AssignmentIcon from "@material-ui/icons/Assignment";
import PeopleIcon from "@material-ui/icons/People";
import DeviceHubIcon from "@material-ui/icons/DeviceHub";
import SettingsIcon from "@material-ui/icons/Settings";
import ExitToAppIcon from "@material-ui/icons/ExitToApp";

function Sidebar() {
  return (
    <div className="sidebar">
      <div className="sidebar__logo">
        <DeviceHubIcon className="sidebar__logo__icon" />
        <h1>JobHub</h1>
      </div>
      <SidebarOption Icon={AccountCircleIcon} title="Profile" />
      <SidebarOption Icon={BusinessCenterIcon} title="Job Advertisements" />
      <SidebarOption Icon={BusinessIcon} title="Companies" />
      <SidebarOption Icon={AssignmentIcon} title="Resume" />
      <SidebarOption Icon={PeopleIcon} title="Friends" />

      <div className="sidebar__footer">
        <SidebarOption Icon={SettingsIcon} title="Settings" />
        <SidebarOption Icon={ExitToAppIcon} title="Logout" />
        <div className="created__by__mehmetkaya">
          <span className="K">
            <a
              href="https://www.linkedin.com/in/mehmet-kaya-14867720a/"
              target="_blank"
            >
              K
            </a>
          </span>{" "}
          <span className="text">Created by Mehmet Kaya</span>
        </div>
      </div>
    </div>
  );
}

export default Sidebar;
