import React from "react";
import { useHistory } from "react-router-dom";
import "../../styles/jobSeekerStyles/JobSeekerProfileOption.css";

function JobSeekerProfileOption({ Icon, title, selected, path }) {
  const history = useHistory();

  const openProfileSection = (path) => {
    history.push(path);
  };
  return (
    <div
      onClick={() => openProfileSection(path)}
      className={`jobSeekerProfileOption ${selected && "option--selected"}`}
    >
      {Icon && <Icon className="jobSeekerProfileOption__icon" />}
      <b className="jobSeekerProfileOption__title">{title}</b>
    </div>
  );
}

export default JobSeekerProfileOption;
