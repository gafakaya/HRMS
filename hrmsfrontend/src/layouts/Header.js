import React from "react";
import "../styles/Header.css";
import SearchIcon from "@material-ui/icons/Search";
import HeaderOption from "./HeaderOption";
import EventAvailableIcon from "@material-ui/icons/EventAvailable";
import NotificationsIcon from "@material-ui/icons/Notifications";
// import NotificationsNoneIcon from '@material-ui/icons/NotificationsNone';
//Todo: Bildirim olduğunda icon değişikliği.
import MessageIcon from "@material-ui/icons/Message";

function Header() {
  return (
    <div className="header">
      <div className="header__search">
          <form className="header__search__input">
            <input type="text" />
            <button type="submit" className="header__search__button">
              <SearchIcon type="submit" className="header__search__logo" />
            </button>
            
          </form>
      </div>
      <div className="header__options">
        <HeaderOption Icon={EventAvailableIcon} title="Events" />
        <HeaderOption Icon={NotificationsIcon} title="Notifications" />
        <HeaderOption Icon={MessageIcon} title="Messages" />
      </div>
    </div>
  );
}

export default Header;
