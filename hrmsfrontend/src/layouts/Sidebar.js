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
import { Link } from "react-router-dom";

function Sidebar() {
  return (
    <div className="sidebar">
      <div className="sidebar__logo">
        <DeviceHubIcon className="sidebar__logo__icon" />
        <Link className="link__logo" to={`/jobAdvertisements/`}>
          <b className="logo">JobHub</b>
        </Link>
      </div>

      <SidebarOption
        Icon={AccountCircleIcon}
        avatar="https://cdn.discordapp.com/avatars/713735093159460887/9644e6ad8f50b1f2f6b4e3abe0649781.webp?size=256" 
        title="Mehmet Kaya"
        path="/jobSeeker/3/profile/"
      />
      <SidebarOption
        Icon={BusinessCenterIcon}
        title="Job Advertisements"
        path="/jobAdvertisements/"
      />
      <SidebarOption Icon={BusinessIcon} title="Companies" path="/companies/" />
      <SidebarOption Icon={AssignmentIcon} title="Resume" path="/resume/" />
      <SidebarOption Icon={PeopleIcon} title="Friends"  path="/friends/"/>

      <div className="sidebar__footer">
        <SidebarOption Icon={SettingsIcon} title="Settings"  path="/settings/" />
        <SidebarOption Icon={ExitToAppIcon} title="Logout" path="/login/"  />
        <div className="created__by__mehmetkaya">
          <span className="K">
            {/* <a
              href="https://www.linkedin.com/in/mehmet-kaya-14867720a/"
              target="_blank"
            > */}
            K{/* </a> */}
          </span>{" "}
          <span className="text">Created by Mehmet Kaya</span>
        </div>
      </div>
    </div>
  );
}

export default Sidebar;
