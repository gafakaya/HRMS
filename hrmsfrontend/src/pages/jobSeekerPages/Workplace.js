import React from "react";
import "../../styles/jobSeekerStyles/Education.css";
import JobSeekerProfileOption from "./JobSeekerProfileOption";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import SchoolIcon from "@material-ui/icons/School";
import WorkIcon from "@material-ui/icons/Work";

function Workplace() {
  // const [jobSeeker, setJobSeeker] = useState({});

  return (
    <div className="workplace">
      <div className="workplace__body">
        {/* Body */}
        <h1>Workplace</h1>
      </div>
      <div className="workplace__options">
        <JobSeekerProfileOption
          path="/jobseeker/3/profile"
          Icon={AccountCircleIcon}
          title="Profile"
        />
        <JobSeekerProfileOption
          path="/jobseeker/3/education"
          Icon={SchoolIcon}
          title="Education"
        />
        <JobSeekerProfileOption
          path="/jobseeker/3/workplaces"
          Icon={WorkIcon}
          title="Workplaces"
          selected={true}
        />
      </div>
    </div>
  );
}

export default Workplace;
