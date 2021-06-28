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
import LanguageIcon from "@material-ui/icons/Language";
import EmojiObjectsIcon from "@material-ui/icons/EmojiObjects";
import AddCircleIcon from "@material-ui/icons/AddCircle";

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
  const [open, setOpen] = useState(false);
  const jobSeekerService = new JobSeekerService();
  const jobSeekerPhotoService = new JobSeekerPhotoService();

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const initialValues = {
    firstName: `${jobSeeker.firstName}`,
    lastName: `${jobSeeker.lastName}`,
    email: `${jobSeeker.email}`,
    dayOfBirth: `${jobSeeker.dayOfBirth}`,
  };

  const schema = Yup.object().shape({
    firstName: Yup.string().required("First name is required."),
    lastName: Yup.string().required("Last name is required."),
    email: Yup.string()
      .email("Please enter email.")
      .required("Email is required."),
    dayOfBirth: Yup.date().nullable().required("Birthday is require.d"),
  });

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
        <Dialog
          open={open}
          onClose={handleClose}
          aria-labelledby="form-dialog-title"
        >
          <DialogTitle
            className="jobSeeker__update__popup jobSeeker__update__popup--title"
            id="form-dialog-title"
          >
            Update Profile
          </DialogTitle>
          <DialogContent className="jobSeeker__update__popup">
            <DialogContentText className="jobSeeker__update__popup__text">
              All your information must be entered.
            </DialogContentText>
            <Formik
              initialValues={initialValues}
              validationSchema={schema}
              onSubmit={(values, { resetForm, setSubmitting }) => {
                setTimeout(() => {
                  setSubmitting(false);
                  resetForm();
                }, 2000);
                console.log(values);
                let jobSeekerUpdate = {
                  firstName: values.firstName,
                  lastName: values.lastName,
                  email: values.email,
                  dayOfBirth: values.dayOfBirth,
                };

                jobSeekerService
                  .update(3, jobSeekerUpdate)
                  .then((result) => console.log(result.data));
              }}
            >
              {({ dirty, isSubmitting, handleSubmit, setFieldValue }) => (
                <form onSubmit={handleSubmit}>
                  <div className="jobSeeker__update__body">
                    <div className="jobSeeker__update__fnAndln">
                      <div className="jobSeeker__update__fn">
                        <label className="label" htmlFor="firstName">
                          First Name:
                        </label>
                        <JobHubTextInput
                          id="firstName"
                          name="firstName"
                          placeholder={jobSeeker.firstName}
                          type="text"
                        />
                      </div>
                      <div className="jobSeeker__update__ln">
                        <label className="label" htmlFor="lastName">
                          Last Name:
                        </label>
                        <JobHubTextInput
                          id="lastName"
                          name="lastName"
                          placeholder={jobSeeker.lastName}
                          type="text"
                        />
                      </div>
                    </div>
                    <div className="jobSeeker__update__email">
                      <label className="label" htmlFor="email">
                        Last Name:
                      </label>
                      <JobHubTextInput
                        id="email"
                        name="email"
                        placeholder={jobSeeker.email}
                        type="text"
                        large="true"
                      />
                    </div>
                    <div className="jobSeeker__update__birthday">
                      <label className="label" htmlFor="dayOfBirth">
                        Birthday:
                      </label>
                      <JobHubTextInput
                        id="dayOfBirth"
                        name="dayOfBirth"
                        placeholder="YYYY-MM-DD"
                        type="text"
                        large="true"
                      />
                    </div>
                    <DialogActions>
                      <Button
                        startIcon={<CancelIcon />}
                        onClick={handleClose}
                        className="jobHub__button--submit"
                      >
                        Close
                      </Button>
                      <Button
                        type="submit"
                        startIcon={<SaveIcon />}
                        disabled={!dirty || isSubmitting}
                        variant="contained"
                        className="jobHub__button--submit"
                      >
                        Update
                      </Button>
                    </DialogActions>
                  </div>
                </form>
              )}
            </Formik>
          </DialogContent>
        </Dialog>
        <Button
          startIcon={<SaveIcon />}
          variant="contained"
          className="jobHub__button--submit"
          onClick={handleClickOpen}
        >
          Update
        </Button>
        <JobSeekerProfileSocial />
        <div className="jobSeeker__body__various__information">
          <div className="jobSeeker__body__vi jobSeeker__body__vi--languages">
            <div className="jobSeeker__body__vi__header">
              <div className="jobSeeker__body__vi__header--title">
                <LanguageIcon />
                <b>Languages</b>
              </div>
              <IconButton>
                <AddCircleIcon className="vi__add" />
              </IconButton>
            </div>
          </div>
          <div className="jobSeeker__body__vi jobSeeker__body__vi--abilities">
            <div className="jobSeeker__body__vi__header">
              <div className="jobSeeker__body__vi__header--title">
                <EmojiObjectsIcon />
                <b>Abilities</b>
              </div>
              <IconButton>
                <AddCircleIcon className="vi__add" />
              </IconButton>
            </div>
          </div>
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
