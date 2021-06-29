import React, { useState } from "react";
// import { useHistory, useParams } from "react-router-dom";
import "../../styles/jobSeekerStyles/JobSeekerProfile.css";
import JobSeekerProfileOption from "./JobSeekerProfileOption";
import AccountCircleIcon from "@material-ui/icons/AccountCircle";
import SchoolIcon from "@material-ui/icons/School";
import WorkIcon from "@material-ui/icons/Work";
import Avatar from "@material-ui/core/Avatar";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";
import DialogTitle from "@material-ui/core/DialogTitle";
import { useEffect } from "react";
import JobSeekerService from "../../services/jobSeekerServices/jobSeekerService";
import JobSeekerPhotoService from "../../services/jobSeekerServices/jobSeekerPhotoService";
import { IconButton, makeStyles } from "@material-ui/core";
import { Formik } from "formik";
import * as Yup from "yup";
import JobHubTextInput from "../../utilities/custom/JobHubTextInput";
import CancelIcon from "@material-ui/icons/Cancel";
import SaveIcon from "@material-ui/icons/Save";
import JobSeekerProfileSocial from "./JobSeekerProfileSocial";
import AddCircleIcon from "@material-ui/icons/AddCircle";
import JobSeekerProfileUpdate from "./JobSeekerProfileUpdate";
import JobSeekerLangUpdate from "./JobSeekerLangUpdate";
import JobSeekerAbilityUpdate from "./JobSeekerAbilityUpdate";

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
    "& > *": {
      margin: theme.spacing(1),
    },
  },
  small: {
    width: theme.spacing(3),
    height: theme.spacing(3),
  },
  large: {
    width: theme.spacing(7),
    height: theme.spacing(7),
  },
}));

function JobSeekerProfile() {
  // const { id } = useParams();
  const classes = useStyles();
  const [jobSeeker, setJobSeeker] = useState({});
  const [jobSeekerPhoto, setJobSeekerPhoto] = useState({});
  const jobSeekerService = new JobSeekerService();
  const jobSeekerPhotoService = new JobSeekerPhotoService();
  const [open, setOpen] = useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  useEffect(() => {
    jobSeekerService
      .getById(3)
      .then((result) => setJobSeeker(result.data.data));

    jobSeekerPhotoService
      .getJobSeekerPhotosByJobSeekerId(3)
      .then((result) => setJobSeekerPhoto(result.data.data));
  }, []);

  return (
    <div className="jobSeekerProfile">
      <div className="jobSeekerProfile__body">
        <div className="jobSeekerProfile__body__detail">
          <Avatar
            alt={`${jobSeeker.firstName} ${jobSeeker.firstName}`}
            src={jobSeekerPhoto.photoUrl}
            className={`${classes.large} jobSeeker__avatar`}
          />
          <div className="jobSeekerProfile__body__item">
            <span>
              <b className="tag">Name:</b>
              {`${jobSeeker.firstName} ${jobSeeker.lastName}`}
            </span>
            <span>
              <b className="tag">Email:</b>
              {`${jobSeeker.email}`}
            </span>
          </div>
          <div className="jobSeekerProfile__body__item">
            <span>
              <b className="tag">Birthday:</b>
              <span>{`${jobSeeker.dayOfBirth}`}</span>
            </span>
            <span>
              <b className="tag">Password:</b>
              {`***************`}
            </span>
          </div>
        </div>
        <JobSeekerProfileUpdate />
        <JobSeekerProfileSocial />
        <div className="jobSeeker__body__various__information">
          <JobSeekerLangUpdate />
          <div className="space"></div>
          <JobSeekerAbilityUpdate />
        </div>
      </div>
      <div className="jobSeekerProfile__options">
        <JobSeekerProfileOption
          path="/jobseeker/3/profile"
          Icon={AccountCircleIcon}
          title="Profile"
          selected={true}
        />
        <JobSeekerProfileOption
          path="/jobseeker/3/education"
          Icon={SchoolIcon}
          title="Education"
        />
        <JobSeekerProfileOption
          path="/jobseeker/3/workplace"
          Icon={WorkIcon}
          title="Workplaces"
        />
      </div>
    </div>
  );
}

export default JobSeekerProfile;
