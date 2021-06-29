import React, { useState, useEffect } from "react";
import "../../styles/jobSeekerStyles/JobSeekerProfile.css";
import { Formik } from "formik";
import * as Yup from "yup";
import JobHubDropdown from "../../utilities/custom/JobHubDropdown";
import CancelIcon from "@material-ui/icons/Cancel";
import SaveIcon from "@material-ui/icons/Save";
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

function JobSeekerLangUpdate() {
  const [open, setOpen] = useState(false);
  const [languages, setLanguages] = useState([]);
  // Dil Seviyesi vs.
  const jobSeekerLanguageService = new JobSeekerLanguageService();

  const deleteLanguages = (jobSeekerAbilityId) => {
    jobSeekerLanguageService.delete(jobSeekerAbilityId);
  };

  useEffect(() => {
    async function getAll() {
      const result =
        await jobSeekerLanguageService.getJobSeekerLanguagesByJobSeekerId(3);
      setLanguages(result.data.data);
    }

    getAll();
  }, []);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const languagesOptions = languages.map((language, index) => ({
    key: index,
    text: language.language.languageName,
    value: language.language.languageId,
  }));

  const initialValues = {
    abilityId: "",
  };

  const schema = Yup.object().shape({
    abilityId: Yup.string().required("Ability is required."),
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
      <div className="jobSeeker__body__vi__body"></div>
      <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="form-dialog-title"
      >
        <DialogTitle id="form-dialog-title">Language</DialogTitle>
        <DialogContent>
          <DialogContentText>Add new languages.</DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} color="primary">
            Cancel
          </Button>
          <Button color="primary">Add</Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}

export default JobSeekerLangUpdate;
