import React, { useEffect, useState } from "react";
import "../../styles/jobAdvertisementStyles/AddJobAdvertisement.css";
import { Formik } from "formik";
import * as Yup from "yup";
import CityService from "../../services/cityService";
import JobTitleService from "../../services/jobTitleService";
import WorkTimeService from "../../services/workTimeService";
import WorkTypeService from "../../services/workTypeService";
import JobAdvertisementService from "../../services/jobAdvertisementServices/jobAdvertisementService";
import AddCircleOutlineIcon from "@material-ui/icons/AddCircleOutline";
import { Button } from "@material-ui/core";
import JobHubTextInput from "../../utilities/custom/JobHubTextInput";
import JobHubDropdown from "../../utilities/custom/JobHubDropdown";
import JobHubTextArea from "../../utilities/custom/JobHubTextArea";
// import { useHistory } from "react-router-dom";

function AddJobAdvertisement() {
  let jobAdvertisementService = new JobAdvertisementService();

  const [cities, setCities] = useState([]);
  const [workTimes, setWorkTimes] = useState([]);
  const [workTypes, setWorkTypes] = useState([]);
  const [jobTitles, setJobTitles] = useState([]);

  useEffect(() => {
    let cityService = new CityService();
    cityService.getCities().then((response) => {
      setCities(response.data.data);
    });

    let jobTitleService = new JobTitleService();
    jobTitleService.getJobTitles().then((response) => {
      setJobTitles(response.data.data);
    });

    let workTypeService = new WorkTypeService();
    workTypeService.getWorkTypes().then((response) => {
      setWorkTypes(response.data.data);
    });

    let workTimeService = new WorkTimeService();
    workTimeService.getWorkTimes().then((response) => {
      setWorkTimes(response.data.data);
    });
  }, []);
  const cityOptions = cities.map((city, index) => ({
    key: index,
    text: city.cityName,
    value: city.id,
  }));
  const workTypesOptions = workTypes.map((workType, index) => ({
    key: index,
    text: workType.workTypeName,
    value: workType.workTypeId,
  }));

  const workTimesOptions = workTimes.map((workTime, index) => ({
    key: index,
    text: workTime.workTimeName,
    value: workTime.workTimeId,
  }));

  const jobTitlesOptions = jobTitles.map((jobTitle, index) => ({
    key: index,
    text: jobTitle.title,
    value: jobTitle.id,
  }));

  const initialValues = {
    jobDescription: "",
    maxSalary: 0,
    minSalary: 0,
    applicationDeadline: "YYYY/MM/DD",
    numberOfOpenPositions: 0,
    cityId: "",
    jobTitleId: "",
    workTypeId: "",
    workTimeId: "",
  };

  const schema = Yup.object().shape({
    jobDescription: Yup.string().required("Job Description is required."),
    minSalary: Yup.number()
      .min(0, "Min Salary cannot be less than 0")
      .required("Min Salary is required."),
    maxSalary: Yup.number()
      .min(0, "Max Salary cannot be less than 0")
      .required("Max Salary is required."),
    numberOfOpenPositions: Yup.number()
      .min(0, "Number Of Open Position cannot be less than 0")
      .required("Number of Open Postion is required"),
    cityId: Yup.string().required("City is required."),
    jobTitleId: Yup.string().required("Job Title is required."),
    workTypeId: Yup.string().required("Work Type is required."),
    workTimeId: Yup.string().required("Work time is required."),
    applicationDeadline: Yup.date()
      .nullable()
      .required("Application Deadline is required"),
  });

  return (
    <div className="addJobAdvertisement">
      <div className="addJobAdvertisement__header">
        <h3>Job Advertisement</h3>
      </div>
      <Formik
        initialValues={initialValues}
        validationSchema={schema}
        onSubmit={(values, { resetForm, setSubmitting }) => {
          console.log(values);
          setTimeout(() => {
            setSubmitting(false);
            resetForm();
          }, 2000);
          values.companyId = 1;
          let jobAdvertisement = {
            applicationDeadline: values.applicationDeadline,
            minSalary: values.minSalary,
            maxSalary: values.maxSalary,
            jobDescription: values.jobDescription,
            numberOfOpenPositions: values.numberOfOpenPositions,
            cityId: values.cityId,
            jobTitleId: values.jobTitleId,
            companyId: values.companyId,
            workTimeId: values.workTimeId,
            workTypeId: values.workTypeId,
          };

          jobAdvertisementService
            .add(jobAdvertisement)
            .then((result) => console.log(result));
          alert(JSON.stringify(values, null, 2));
        }}
      >
        {({ dirty, isSubmitting, handleSubmit, setFieldValue }) => (
          <form onSubmit={handleSubmit}>
            <div className="addJobAdvertisement__body">
              <div className="addJobAdvertisement__body__description">
                <label className="label" htmlFor="jobDescription">
                  Job Description:
                </label>
                <JobHubTextArea
                  id="jobDescription"
                  name="jobDescription"
                  placeholder="Description"
                />
              </div>
              <div className="addJobAdvertisement__body__items">
                <div className="addJobAdvertisement__body__section">
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="maxSalary">
                      Max Salary:
                    </label>
                    <JobHubTextInput
                      id="maxSalary"
                      name="maxSalary"
                      type="text"
                    />
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="minSalary">
                      Min Salary:
                    </label>
                    <JobHubTextInput
                      id="minSalary"
                      name="minSalary"
                      type="text"
                    />
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="numberOfOpenPositions">
                      Number of Open Positions:
                    </label>
                    <JobHubTextInput
                      id="numberOfOpenPositions"
                      name="numberOfOpenPositions"
                      type="text"
                    />
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="applicationDeadline">
                      Applicaiton Deadline:
                    </label>
                    <JobHubTextInput
                      id="applicationDeadline"
                      name="applicationDeadline"
                      type="text"
                    />
                  </div>
                </div>
                <div className="addJobAdvertisement__body__section">
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="workTypeId">
                      Work Type:
                    </label>
                    <JobHubDropdown
                      id="workTypeId"
                      name="workTypeId"
                      placeholder="Work Type"
                      options={workTypesOptions}
                      onChange={(event, data) =>
                        setFieldValue("workTypeId", data.value)
                      }
                    />
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="workTimeId">
                      Work Time:
                    </label>
                    <JobHubDropdown
                      name="workTimeId"
                      placeholder="Work Time"
                      options={workTimesOptions}
                      onChange={(event, data) =>
                        setFieldValue("workTimeId", data.value)
                      }
                    />
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="jobTitleId">
                      Job Title:
                    </label>
                    <JobHubDropdown
                      name="jobTitleId"
                      placeholder="Job Title"
                      options={jobTitlesOptions}
                      onChange={(event, data) =>
                        setFieldValue("jobTitleId", data.value)
                      }
                    />
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="cityId">
                      City:
                    </label>
                    <JobHubDropdown
                      id="cityId"
                      name="cityId"
                      placeholder="City"
                      options={cityOptions}
                      onChange={(event, data) =>
                        setFieldValue("cityId", data.value)
                      }
                    />
                  </div>
                </div>
              </div>
              <Button
                startIcon={<AddCircleOutlineIcon />}
                type="submit"
                disabled={!dirty || isSubmitting}
                variant="contained"
                className="jobHub__button--submit"
              >
                Add
              </Button>
            </div>
          </form>
        )}
      </Formik>
    </div>
  );
}

export default AddJobAdvertisement;
