import React, { useState, useEffect } from "react";
import "../../styles/jobSeekerStyles/JobSeekerProfile.css";
import { Formik } from "formik";
import * as Yup from "yup";
import JobHubDropdown from "../../utilities/custom/JobHubDropdown";
import CancelIcon from "@material-ui/icons/Cancel";
import SaveIcon from "@material-ui/icons/Save";
import StarIcon from "@material-ui/icons/Star";
import LanguageIcon from "@material-ui/icons/Language";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";
import DialogTitle from "@material-ui/core/DialogTitle";
import { IconButton } from "@material-ui/core";
import AddCircleIcon from "@material-ui/icons/AddCircle";
import JobSeekerLanguageService from "../../services/jobSeekerServices/jobSeekerLanguageService";
import LanguageLevelService from "../../services/languageLevelService";
import LanguageService from "../../services/languageService";

function JobSeekerLangUpdate() {
  const [open, setOpen] = useState(false);
  const [languages, setLanguages] = useState([]);
  const [jobSeekerLanguages, setJobSeekerLanguages] = useState([]);
  const [languageLevels, setLanguageLevels] = useState([]);
  // Dil Seviyesi vs.
  const jobSeekerLanguageService = new JobSeekerLanguageService();
  const languageLevelService = new LanguageLevelService();
  const languageService = new LanguageService();

  const deleteLanguage = (languageId) => {
    console.log(languageId);
    jobSeekerLanguageService.delete(languageId);
  };

  useEffect(() => {
    jobSeekerLanguageService
      .getJobSeekerLanguagesByJobSeekerId(3)
      .then((result) => setJobSeekerLanguages(result.data.data));

    languageService
      .getLanguages()
      .then((result) => setLanguages(result.data.data));

    languageLevelService
      .getLanguageLevels()
      .then((result) => setLanguageLevels(result.data.data));
  }, []);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const languagesOptions = languages.map((language, index) => ({
    key: index,
    text: language.languageName,
    value: language.languageId,
  }));

  const languageLevelOptions = languageLevels.map((languageLevel, index) => ({
    key: index,
    text: languageLevel.languageLevel,
    value: languageLevel.languageLevelId,
  }));

  const initialValues = {
    languageId: "",
    languageLevelId: "",
  };

  const schema = Yup.object().shape({
    languageId: Yup.string().required("Language is required."),
    languageLevelId: Yup.string().required("Language level is required."),
  });

  return (
    <div className="jobSeeker__body__vi jobSeeker__body__vi--languages">
      <div className="jobSeeker__body__vi__header">
        <div className="jobSeeker__body__vi__header--title">
          <LanguageIcon />
          <b>Languages</b>
        </div>
        <IconButton onClick={handleClickOpen}>
          <AddCircleIcon className="vi__add" />
        </IconButton>
      </div>
      <div className="jobSeeker__body__vi__body">
        {jobSeekerLanguages.map((jobSeekerLanguage) => (
          <div
            key={jobSeekerLanguage.jobSeekerLanguageId}
            className="ability__item"
          >
            <span>{jobSeekerLanguage.language.languageName}</span>
            <IconButton
              onClick={() =>
                deleteLanguage(jobSeekerLanguage.jobSeekerLanguageId)
              }
              className="ability__delete__button"
              size="small"
            >
              <CancelIcon />
            </IconButton>
          </div>
        ))}
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
          Language
        </DialogTitle>
        <DialogContent className="jobSeeker__update__popup">
          <DialogContentText className="jobSeeker__update__popup__text">
            Add new language.
          </DialogContentText>
        </DialogContent>
        <Formik
          initialValues={initialValues}
          validationSchema={schema}
          onSubmit={(values, { resetForm, setSubmitting }) => {
            setTimeout(() => {
              setSubmitting(false);
              resetForm();
            }, 2000);
            console.log(values);

            let jobSeekerLanguage = {
              language: {
                languageId: values.languageId,
              },
              jobSeeker: {
                id: 3,
              },
              languageLevel: {
                languageLevelId: values.languageLevelId,
              },
              jobSeekerLanguageId: 0,
            };

            console.log(jobSeekerLanguage);

            jobSeekerLanguageService
              .add(jobSeekerLanguage)
              .then((result) => result.data);
          }}
        >
          {({ dirty, isSubmitting, handleSubmit, setFieldValue }) => (
            <form onSubmit={handleSubmit}>
              <div className="jobSeeker__update__body">
                <div className="jobSeeker__update__language__area">
                  <div className="jobSeeker__update__language">
                    <label className="label" htmlFor="abilityId">
                      Language:
                    </label>
                    <JobHubDropdown
                      id="languageId"
                      name="languageId"
                      placeholder="Language"
                      options={languagesOptions}
                      onChange={(event, data) =>
                        setFieldValue("languageId", data.value)
                      }
                    />
                  </div>
                  <div className="jobSeeker__update__languagelevel">
                    <label className="label" htmlFor="abilityId">
                      Language Level:
                    </label>
                    <JobHubDropdown
                      id="languageLevelId"
                      name="languageLevelId"
                      placeholder="Language"
                      options={languageLevelOptions}
                      onChange={(event, data) =>
                        setFieldValue("languageLevelId", data.value)
                      }
                    />
                  </div>
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
                    Add
                  </Button>
                </DialogActions>
              </div>
            </form>
          )}
        </Formik>
      </Dialog>
    </div>
  );
}

export default JobSeekerLangUpdate;
