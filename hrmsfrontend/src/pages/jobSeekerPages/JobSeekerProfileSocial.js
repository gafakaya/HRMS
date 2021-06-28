import React, { useEffect, useState } from "react";
import { IconButton } from "@material-ui/core";
import { Formik } from "formik";
import * as Yup from "yup";
import JobHubTextInput from "../../utilities/custom/JobHubTextInput";
import SaveIcon from "@material-ui/icons/Save";
import SocialMediaService from "../../services/socialMediaService";

function JobSeekerProfileSocial() {
  const socialMediaService = new SocialMediaService();

  const [jobSeekerGitHub, setJobSeekerGitHub] = useState({});
  const [jobSeekerLinkedin, setJobSeekerLinkedin] = useState({});

  const githubSchema = Yup.object().shape({
    gitHubLink: Yup.string(),
  });

  const linkedinSchema = Yup.object().shape({
    linkedinLink: Yup.string(),
  });

  useEffect(() => {
    socialMediaService
      .getByJobSeekerIdAndLinkTyepId(3, 1)
      .then((result) => setJobSeekerGitHub(result.data.data));

    socialMediaService
      .getByJobSeekerIdAndLinkTyepId(3, 2)
      .then((result) => setJobSeekerLinkedin(result.data.data));
  }, []);

  return (
    <div className="jobSeeker__body__social">
      <div className="jobSeeker__body__social--item jobSeeker__body__social--github">
        <Formik
          initialValues={{ gitHubLink: "" }}
          validationSchema={githubSchema}
          onSubmit={(values, { resetForm, setSubmitting }) => {
            setTimeout(() => {
              setSubmitting(false);
              resetForm();
            }, 2000);

            let socialMedia = {
              jobSeeker: jobSeekerGitHub.jobSeeker,
              link: values.gitHubLink,
              linkType: jobSeekerGitHub.linkType,
              socialMediaId: jobSeekerGitHub.socialMediaId,
            };
            console.log(socialMedia);

            socialMediaService
              .update(socialMedia)
              .then((result) => console.log(result));
          }}
        >
          {({ dirty, isSubmitting, handleSubmit }) => (
            <form onSubmit={handleSubmit}>
              <label className="label" htmlFor="gitHubLink">
                Github:
              </label>
              <div className="social__input__area github__input__area">
                <JobHubTextInput
                  id="gitHubLink"
                  name="gitHubLink"
                  placeholder={`${jobSeekerGitHub.link}`}
                  type="text"
                  responsive="true"
                />
                <IconButton type="submit" disabled={!dirty || isSubmitting}>
                  <SaveIcon />
                </IconButton>
              </div>
            </form>
          )}
        </Formik>
      </div>
      <div className="jobSeeker__body__social--item jobSeeker__body__social--linkedin">
        <Formik
          initialValues={{ linkedinLink: "" }}
          validationSchema={linkedinSchema}
          onSubmit={(values, { resetForm, setSubmitting }) => {
            setTimeout(() => {
              setSubmitting(false);
              resetForm();
            }, 2000);
            console.log(values);

            let socialMedia = {
              jobSeeker: jobSeekerLinkedin.jobSeeker,
              link: values.linkedinLink,
              linkType: jobSeekerLinkedin.linkType,
              socialMediaId: jobSeekerLinkedin.socialMediaId,
            };
            console.log(socialMedia);

            socialMediaService
              .update(socialMedia)
              .then((result) => console.log(result));
          }}
        >
          {({ dirty, isSubmitting, handleSubmit }) => (
            <form onSubmit={handleSubmit}>
              <label className="label" htmlFor="linkedinLink">
                Linkedin:
              </label>
              <div className="social__input__area linkedin__input__area">
                <JobHubTextInput
                  id="linkedinLink"
                  name="linkedinLink"
                  placeholder={`${jobSeekerLinkedin.link}`}
                  type="text"
                  responsive="true"
                />
                <IconButton type="submit" disabled={!dirty || isSubmitting}>
                  <SaveIcon />
                </IconButton>
              </div>
            </form>
          )}
        </Formik>
      </div>
    </div>
  );
}

export default JobSeekerProfileSocial;
