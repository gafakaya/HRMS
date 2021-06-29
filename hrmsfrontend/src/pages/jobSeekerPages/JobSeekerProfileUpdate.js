import React, { useEffect, useState } from "react";
import { Formik } from "formik";
import * as Yup from "yup";
import JobHubTextInput from "../../utilities/custom/JobHubTextInput";
import CancelIcon from "@material-ui/icons/Cancel";
import SaveIcon from "@material-ui/icons/Save";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";
import DialogTitle from "@material-ui/core/DialogTitle";
import JobSeekerService from "../../services/jobSeekerServices/jobSeekerService";
import { Button } from "@material-ui/core";

function JobSeekerProfileUpdate() {
  const [open, setOpen] = useState(false);
  const [jobSeeker, setJobSeeker] = useState({});
  const jobSeekerService = new JobSeekerService();

  useEffect(() => {
    jobSeekerService
      .getById(3)
      .then((result) => setJobSeeker(result.data.data));
  }, []);

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
  return (
    <div>
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
    </div>
  );
}

export default JobSeekerProfileUpdate;
