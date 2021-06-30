import React, { useState } from "react";
import "../../styles/jobSeekerStyles/JobSeekerProfile.css";
import { Formik } from "formik";
import * as Yup from "yup";
import JobHubDropdown from "../../utilities/custom/JobHubDropdown";
import CancelIcon from "@material-ui/icons/Cancel";
import SaveIcon from "@material-ui/icons/Save";
import EmojiObjectsIcon from "@material-ui/icons/EmojiObjects";
import Button from "@material-ui/core/Button";
import Dialog from "@material-ui/core/Dialog";
import DialogActions from "@material-ui/core/DialogActions";
import DialogContent from "@material-ui/core/DialogContent";
import DialogContentText from "@material-ui/core/DialogContentText";
import DialogTitle from "@material-ui/core/DialogTitle";
import { IconButton } from "@material-ui/core";
import AddCircleIcon from "@material-ui/icons/AddCircle";
import { useEffect } from "react";
import JobSeekerAbilityService from "../../services/jobSeekerServices/jobSeekerAbilityService";

function JobSeekerAbilityUpdate() {
  const [open, setOpen] = useState(false);
  const [abilities, setAbilities] = useState([]);
  const jobSeekerAbilityService = new JobSeekerAbilityService();

  const deleteAbililty = (jobSeekerAbilityId) => {
    jobSeekerAbilityService.delete(jobSeekerAbilityId);
  };

  useEffect(() => {
    async function getAll() {
      const result =
        await jobSeekerAbilityService.getJobSeekerAbilitiesByJobSeekerId(3);
      setAbilities(result.data.data);
    }

    getAll();
  }, []);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const abilityOptions = abilities.map((ability, index) => ({
    key: index,
    text: ability.ability.abilityName,
    value: ability.ability.abilityId,
  }));

  const initialValues = {
    abilityId: "",
  };

  const schema = Yup.object().shape({
    abilityId: Yup.string().required("Ability is required."),
  });

  return (
    <div className="jobSeeker__body__vi jobSeeker__body__vi--abilities">
      <div className="jobSeeker__body__vi__header">
        <div className="jobSeeker__body__vi__header--title">
          <EmojiObjectsIcon />
          <b>Abilities</b>
        </div>
        <IconButton onClick={handleClickOpen}>
          <AddCircleIcon className="vi__add" />
        </IconButton>
      </div>
      <div className="jobSeeker__body__vi__body">
        {abilities.map((ability) => (
          <div key={ability.jobSeekerAbilityId} className="ability__item">
            <span>{ability.ability.abilityName}</span>
            <IconButton
              onClick={() => deleteAbililty(ability.jobSeekerAbilityId)}
              className="ability__delete__button"
              size="small"
            >
              <CancelIcon />
            </IconButton>
          </div>
        ))}
      </div>
      <div className="jobSeeker__body__vi__footer"></div>
      <Dialog
        open={open}
        onClose={handleClose}
        aria-labelledby="form-dialog-title"
      >
        <DialogTitle
          className="jobSeeker__update__popup jobSeeker__update__popup--title"
          id="form-dialog-title"
        >
          Abilities
        </DialogTitle>
        <DialogContent className="jobSeeker__update__popup">
          <DialogContentText className="jobSeeker__update__popup__text">
            Add new abilities.
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

            let jobSeekerAbility = {
              ability: {
                abilityId: values.abilityId,
              },
              jobSeeker: {
                id: 3,
              },
              jobSeekerAbilityId: 0,
            };

            console.log(jobSeekerAbility);

            jobSeekerAbilityService
              .add(jobSeekerAbility)
              .then((result) => result.data);
          }}
        >
          {({ dirty, isSubmitting, handleSubmit, setFieldValue }) => (
            <form onSubmit={handleSubmit}>
              <div className="jobSeeker__update__body">
                <div className="jobSeeker__update__ability">
                  <label className="label" htmlFor="abilityId">
                    Ability:
                  </label>
                  <JobHubDropdown
                    id="abilityId"
                    name="abilityId"
                    placeholder="Ability"
                    options={abilityOptions}
                    onChange={(event, data) =>
                      setFieldValue("abilityId", data.value)
                    }
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

export default JobSeekerAbilityUpdate;
