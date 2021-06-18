import React, { useEffect, useState } from "react";
import "../styles/AddJobAdvertisement.css";
import { Formik } from "formik";
import * as Yup from "yup";
import CityService from "../services/cityService";
import JobTitleService from "../services/jobTitleService";
import WorkTimeService from "../services/workTimeService";
import WorkTypeService from "../services/workTypeService";
import { Dropdown } from "semantic-ui-react";
import JobAdvertisementService from "../services/jobAdvertisementService";
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

  return (
    <div className="addJobAdvertisement">
      <div className="addJobAdvertisement__header">
        <h3>Job Advertisement</h3>
      </div>
      <div className="addJobAdvertisement__body">
        <Formik
          initialValues={{
            jobDescription: "",
            maxSalary: 0,
            minSalary: 0,
            applicationDeadline: "",
            numberOfOpenPositions: 0,
            cityId: "",
            jobTitleId: "",
            workTypeId: "",
            workTimeId: "",
          }}
          validationSchema={Yup.object().shape({
            jobDescription: Yup.string().required(
              "Job Description is required."
            ),
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
          })}
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
          {({
            values,
            touched,
            errors,
            dirty,
            isSubmitting,
            handleSubmit,
            handleReset,
            handleChange,
            setFieldValue,
          }) => (
            <form onSubmit={handleSubmit}>
              <div className="addJobAdvertisement__body__description">
                <label className="label" htmlFor="jobDescription">
                  Job Description:
                </label>
                <textarea
                  id="jobDescription"
                  className="textarea"
                  value={values.jobDescription}
                  onChange={handleChange}
                />
                {errors.jobDescription && touched.jobDescription && (
                  <div className="input__feedback">{errors.jobDescription}</div>
                )}
              </div>
              <div className="addJobAdvertisement__body__items">
                <div className="addJobAdvertisement__body__section">
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="maxSalary">
                      Max Salary:
                    </label>
                    <input
                      id="maxSalary"
                      type="text"
                      className="input"
                      value={values.maxSalary}
                      onChange={handleChange}
                    />
                    {errors.maxSalary && touched.maxSalary && (
                      <div className="input__feedback">{errors.maxSalary}</div>
                    )}
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="minSalary">
                      Min Salary:
                    </label>
                    <input
                      id="minSalary"
                      type="text"
                      className="input"
                      value={values.minSalary}
                      onChange={handleChange}
                    />
                    {errors.minSalary && touched.minSalary && (
                      <div className="input__feedback">{errors.minSalary}</div>
                    )}
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="numberOfOpenPositions">
                      Number of Open Positions:
                    </label>
                    <input
                      id="numberOfOpenPositions"
                      type="text"
                      className="input"
                      value={values.numberOfOpenPositions}
                      onChange={handleChange}
                    />
                    {errors.numberOfOpenPositions &&
                      touched.numberOfOpenPositions && (
                        <div className="input__feedback">
                          {errors.numberOfOpenPositions}
                        </div>
                      )}
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="applicationDeadline">
                      Applicaiton Deadline:
                    </label>
                    <input
                      id="applicationDeadline"
                      type="text"
                      className="input"
                      value={values.applicationDeadline}
                      onChange={handleChange}
                    />
                    {errors.applicationDeadline &&
                      touched.applicationDeadline && (
                        <div className="input__feedback">
                          {errors.applicationDeadline}
                        </div>
                      )}
                  </div>
                </div>
                <div className="addJobAdvertisement__body__section">
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="workType">
                      Work Type:
                    </label>
                    <Dropdown
                      id="workTypeId"
                      // className="dropdown"
                      placeholder="Work Type"
                      fluid
                      search
                      selection
                      options={workTypesOptions}
                      onChange={(event, data) =>
                        setFieldValue("workTypeId", data.value)
                      }
                    />
                    {errors.workTypeId && touched.workTypeId && (
                      <div className="input__feedback">{errors.workTypeId}</div>
                    )}
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="workTimeId">
                      Work Time:
                    </label>
                    <Dropdown
                      id="workTimeId"
                      // className="dropdown"
                      placeholder="Work Time"
                      fluid
                      search
                      selection
                      options={workTimesOptions}
                      onChange={(event, data) =>
                        setFieldValue("workTimeId", data.value)
                      }
                    />
                    {errors.workTimeId && touched.workTimeId && (
                      <div className="input__feedback">{errors.workTimeId}</div>
                    )}
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="jobTitle">
                      Job Title:
                    </label>
                    <Dropdown
                      id="jobTitleId"
                      // className="dropdown"
                      placeholder="Job Title"
                      fluid
                      search
                      selection
                      options={jobTitlesOptions}
                      onChange={(event, data) =>
                        setFieldValue("jobTitleId", data.value)
                      }
                    />
                    {errors.jobTitleId && touched.jobTitleId && (
                      <div className="input__feedback">{errors.jobTitleId}</div>
                    )}
                  </div>
                  <div className="addJobAdvertisement__body__section__item">
                    <label className="label" htmlFor="City">
                      City:
                    </label>
                    <Dropdown
                      id="city"
                      name="city"
                      className="dropdown"
                      clearable
                      item
                      placeholder="City"
                      search
                      selection
                      onChange={(event, data) =>
                        setFieldValue("cityId", data.value)
                      }
                      options={cityOptions}
                    />
                    {errors.cityId && touched.cityId && (
                      <div className="input__feedback">{errors.cityId}</div>
                    )}
                  </div>
                  <button
                    type="submit"
                    className="button"
                    disabled={!dirty || isSubmitting}
                  >
                    Add
                  </button>
                </div>
              </div>
            </form>
          )}
        </Formik>
      </div>
    </div>
  );
}

export default AddJobAdvertisement;
