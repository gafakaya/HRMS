import React, { useEffect, useState } from "react";
import "../styles/AddJobAdvertisement.css";
import { useFormik } from "formik";
import * as Yup from "yup";
import CityService from "../services/cityService";
import JobTitleService from "../services/jobTitleService";
import WorkTimeService from "../services/workTimeService";
import WorkTypeService from "../services/workTypeService";
import { Dropdown, Form } from "semantic-ui-react";
import JobAdvertisementService from "../services/jobAdvertisementService";
import { useHistory } from "react-router-dom";

function AddJobAdvertisement() {
  let jobAdvertisementService = new JobAdvertisementService();
  const [cities, setCities] = useState([]);
  const [workTimes, setWorkTimes] = useState([]);
  const [workTypes, setWorkTypes] = useState([]);
  const [jobTitles, setJobTitles] = useState([]);

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
  }, [jobTitles, cities, workTimes, workTypes]);

  const history = useHistory();

  const formik = useFormik({
    initialValues: {
      jobDescription: "",
      maxSalary: 0,
      minSalary: 0,
      numberOfOpenPositions: 0,
      cityId: "",
      jobTitleId: "",
      workTypeId: "",
      workTimeId: "",
      applicationDeadline: "",
    },
    validationSchema: Yup.object({
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
      applicaitonDeadline: Yup.date()
        .nullable()
        .required("Application Deadline is required"),
    }),
    onSubmit: (values) => {
      values.companyId = 1;
      jobAdvertisementService
        .add(values)
        .then((result) => console.log(result.data.data));
      history.push("/jobAdvertisements");
    },
  });

  const handleChangeCustom = (value, fieldName) => {
    formik.setFieldValue(fieldName, value);
  };

  return (
    <div className="addJobAdvertisement">
      <div className="addJobAdvertisement__header">
        <h3>Job Advertisement</h3>
      </div>
      <div>
        <Form onSubmit={formik.handleSubmit} className="addJobAdvertisement__body">
          <Form.Field>
            <div className="addJobAdvertisement__body__description">
              <label className="label" htmlFor="jobDescription">
                Job Description:
              </label>
              <textarea
                id="jobDescription"
                className="textarea"
                value={formik.values.jobDescription}
                onChange={formik.handleChange}
              />
              {formik.errors.jobDescription &&
                formik.touched.jobDescription && (
                  <div className="input__feedback">
                    {formik.errors.jobDescription}
                  </div>
                )}
            </div>
          </Form.Field>
          <div className="addJobAdvertisement__body__items">
            <div className="addJobAdvertisement__body__section">
              <Form.Field>
                <div className="addJobAdvertisement__body__section__item">
                  <label className="label" htmlFor="maxSalary">
                    Max Salary:
                  </label>
                  <input
                    id="maxSalary"
                    type="text"
                    className="input"
                    value={formik.values.maxSalary}
                    onChange={formik.handleChange}
                  />
                  {formik.errors.maxSalary && formik.touched.maxSalary && (
                    <div className="input__feedback">
                      {formik.errors.maxSalary}
                    </div>
                  )}
                </div>
              </Form.Field>
              <Form.Field>
                <div className="addJobAdvertisement__body__section__item">
                  <label className="label" htmlFor="minSalary">
                    Min Salary:
                  </label>
                  <input
                    id="minSalary"
                    type="text"
                    className="input"
                    value={formik.values.minSalary}
                    onChange={formik.handleChange}
                  />
                  {formik.errors.minSalary && formik.touched.minSalary && (
                    <div className="input__feedback">
                      {formik.errors.minSalary}
                    </div>
                  )}
                </div>
              </Form.Field>
              <Form.Field>
                <div className="addJobAdvertisement__body__section__item">
                  <label className="label" htmlFor="numberOfOpenPositions">
                    Number of Open Positions:
                  </label>
                  <input
                    id="numberOfOpenPositions"
                    type="text"
                    className="input"
                    value={formik.values.numberOfOpenPositions}
                    onChange={formik.handleChange}
                  />
                  {formik.errors.numberOfOpenPositions &&
                    formik.touched.numberOfOpenPositions && (
                      <div className="input__feedback">
                        {formik.errors.numberOfOpenPositions}
                      </div>
                    )}
                </div>
              </Form.Field>
              <Form.Field>
                <div className="addJobAdvertisement__body__section__item">
                  <label className="label" htmlFor="applicationDeadline">
                    Applicaiton Deadline:
                  </label>
                  <input
                    id="applicationDeadline"
                    type="text"
                    className="input"
                    value={formik.values.applicationDeadline}
                    onChange={formik.handleChange}
                  />
                  {formik.errors.applicationDeadline &&
                    formik.touched.applicationDeadline && (
                      <div className="input__feedback">
                        {formik.errors.applicationDeadline}
                      </div>
                    )}
                </div>
              </Form.Field>
            </div>
            <div className="addJobAdvertisement__body__section">
              <Form.Field>
                <div className="addJobAdvertisement__body__section__item">
                  <label className="label" htmlFor="workType">
                    Work Type:
                  </label>
                  <Dropdown
                    id="workTypeId"
                    name="workTypeId"
                    className="dropdown"
                    clearable
                    item
                    placeholder="Work Type"
                    fluid
                    search
                    selection
                    value={formik.values.workTypeId}
                    onChange={(event, data) =>
                      handleChangeCustom(data.value, "workTypeId")
                    }
                    options={workTypesOptions}
                  />
                  {formik.errors.workTypeId && formik.touched.workTypeId && (
                    <div className="input__feedback">
                      {formik.errors.workTypeId}
                    </div>
                  )}
                </div>
              </Form.Field>
              <Form.Field>
                <div className="addJobAdvertisement__body__section__item">
                  <label className="label" htmlFor="workType">
                    Work Time:
                  </label>
                  <Dropdown
                    id="workTimeId"
                    name="workTimeId"
                    className="dropdown"
                    clearable
                    item
                    placeholder="Work Time"
                    fluid
                    search
                    selection
                    value={formik.values.workTimeId}
                    onChange={(event, data) =>
                      handleChangeCustom(data.value, "workTimeId")
                    }
                    options={workTimesOptions}
                  />
                  {formik.errors.workTimeId && formik.touched.workTimeId && (
                    <div className="input__feedback">
                      {formik.errors.workTimeId}
                    </div>
                  )}
                </div>
              </Form.Field>
              <Form.Field>
                <div className="addJobAdvertisement__body__section__item">
                  <label className="label" htmlFor="jobTitle">
                    Job Title:
                  </label>
                  <Dropdown
                    id="jobTitleId"
                    name="jobTitleId"
                    className="dropdown"
                    clearable
                    item
                    placeholder="Job Title"
                    fluid
                    search
                    selection
                    value={formik.values.jobTitleId}
                    onChange={(event, data) =>
                      handleChangeCustom(data.value, "jobTitleId")
                    }
                    options={jobTitlesOptions}
                  />
                  {formik.errors.jobTitleId && formik.touched.jobTitleId && (
                    <div className="input__feedback">
                      {formik.errors.jobTitleId}
                    </div>
                  )}
                </div>
              </Form.Field>
              <Form.Field>
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
                      handleChangeCustom(data.value, "cityId")
                    }
                    value={formik.values.cityId}
                    options={cityOptions}
                  />
                  {formik.errors.city && formik.touched.city && (
                    <div className="input__feedback">{formik.errors.city}</div>
                  )}
                </div>
              </Form.Field>
            </div>
          </div>
          <button className="button" type="submit">
            Add
          </button>
        </Form>
      </div>
    </div>
  );
}

export default AddJobAdvertisement;
