import React, { useEffect, useState } from "react";
import "../../styles/jobSeekerStyles/Education.css";
import JobSeekerProfileOption from "./JobSeekerProfileOption";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import SchoolIcon from "@material-ui/icons/School";
import WorkIcon from "@material-ui/icons/Work";
import JobSeekerSchoolService from "../../services/jobSeekerServices/jobSeekerSchoolService";

function Education() {
  const [jobSeekerSchool, setJobSeekerSchool] = useState({});

  useEffect(() => {
    const jobSeekerSchoolService = new JobSeekerSchoolService();
    jobSeekerSchoolService
      .getJobSeekerSchoolsByJobSeekerId(3)
      .then((result) => setJobSeekerSchool(result.data.data));
  }, []);

  return (
    <div className="education">
      <div className="education__body">
        {/* Body */}
        <h1>Education</h1>
      </div>
      <div className="education__options">
        <JobSeekerProfileOption
          path="/jobseeker/3/profile"
          Icon={AccountCircleIcon}
          title="Profile"
        />
        <JobSeekerProfileOption
          path="/jobseeker/3/education"
          Icon={SchoolIcon}
          title="Education"
          selected={true}
        />
        <JobSeekerProfileOption
          path="/jobseeker/3/workplaces"
          Icon={WorkIcon}
          title="Workplaces"
        />
      </div>
    </div>
  );
}

export default Education;
