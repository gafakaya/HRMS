import React from "react";
import { useHistory } from "react-router-dom";
import "../styles/SidebarOption.css";
import { makeStyles } from "@material-ui/core";
import Avatar from "@material-ui/core/Avatar";

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
    "& > *": {
      margin: theme.spacing(1),
    },
  },
  small: {
    width: theme.spacing(2.5),
    height: theme.spacing(2.5),
  },
  large: {
    width: theme.spacing(7),
    height: theme.spacing(7),
  },
}));
function SidebarOption({ avatar, Icon, title, path }) {
  const classes = useStyles();
  const history = useHistory();

  const openAppSection = (path) => {
    history.push(path);
  };
  return (
    <div onClick={() => openAppSection(path)} className="sidebarOption">
      {!avatar && Icon && <Icon className="sidebarOption__icon" />}
      {avatar && (
        <Avatar
          src="https://cdn.discordapp.com/avatars/713735093159460887/9644e6ad8f50b1f2f6b4e3abe0649781.webp?size=256"
          className={`${classes.small} sidebarOption__icon`}
        />
      )}
      <b className="sidebarOption__title">{title}</b>
    </div>
  );
}

export default SidebarOption;
