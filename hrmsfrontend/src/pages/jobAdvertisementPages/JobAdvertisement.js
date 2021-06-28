import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Avatar, makeStyles } from "@material-ui/core";
import JobAdvertisementService from "../../services/jobAdvertisementServices/jobAdvertisementService";
import "../../styles/jobAdvertisementStyles/JobAdvertisement.css";
import StarBorderIcon from "@material-ui/icons/StarBorder";
import StarIcon from "@material-ui/icons/Star";
import ThumbUpIcon from "@material-ui/icons/ThumbUp";
import InsertCommentIcon from "@material-ui/icons/InsertComment";
import AssignmentIcon from "@material-ui/icons/Assignment";
import DirectionsIcon from '@material-ui/icons/Directions';

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
    width: theme.spacing(4),
    height: theme.spacing(4),
  },
}));

function JobAdvertisement() {
  const classes = useStyles();
  const [active, setActive] = useState(false);
  const [jobAdvertisements, setJobAdvertisements] = useState([]);

  const isFavorited = () => {
    if (active) {
      setActive(false);
    } else {
      setActive(true);
    }
  };

  useEffect(() => {
    let jobAdvertisementService = new JobAdvertisementService();
    jobAdvertisementService
      .getJobAdvertisementsWithCompanyOrderByCreatedAt()
      .then((result) => setJobAdvertisements(result.data.data));
  }, []);

  return (
    <div>
      {jobAdvertisements.map((jobAdvertisement) => (
        <div className="jobAdvertisement" key={jobAdvertisement.id}>
          <div className="jobAdvertisement__header">
            <div className="jobAdvertisement__header__company">
              <Avatar id="avatar" className={classes.large} src="" />
              <div className="jobAdvertisement__header__company_info">
                {<b> {jobAdvertisement.companyName}</b>}
                <p className="jobAdvertisement__time">
                  {new Date(jobAdvertisement.createdAt).getDate("en-US")}:
                  {new Date(jobAdvertisement.createdAt).getMonth("en-US") < 10
                    ? "0" +
                      new Date(jobAdvertisement.createdAt).getMonth("en-US")
                    : new Date(jobAdvertisement.createdAt).getMonth("en-US")}
                  :{new Date(jobAdvertisement.createdAt).getFullYear("en-US")}-
                  {new Date(jobAdvertisement.createdAt).toLocaleTimeString(
                    "en-US"
                  )}
                </p>
              </div>
            </div>
            {active ? (
              <StarIcon
                onClick={() => isFavorited()}
                className="favorite__activated"
              />
            ) : (
              <StarBorderIcon
                onClick={() => isFavorited()}
                className="favorite__nonactivated"
              />
            )}
          </div>
          <div className="jobAdvertisement__body">
            <p className="jobAdvertisement__body__description">
              {jobAdvertisement.jobDescription}
            </p>
            <div className="jobAdvertisement__body__item">
              <span>Job Title: </span>
              {jobAdvertisement.title}
            </div>
            <div className="jobAdvertisement__body__item">
              <span>City: </span>
              {jobAdvertisement.cityName}
            </div>
            <div className="jobAdvertisement__body__item">
              <span>Number of Open Positions: </span>
              {jobAdvertisement.numberOfOpenPositions}
            </div>
            <div className="jobAdvertisement__body__item">
              <span>Work Time: </span>
              {jobAdvertisement.workTime}
            </div>
            <div className="jobAdvertisement__body__item">
              <span>Work Type: </span>
              {jobAdvertisement.workType}
            </div>
            <div className="jobAdvertisement__body__item">
              <span>Max Salary: </span>
              {jobAdvertisement.maxSalary}$
            </div>
            <div className="jobAdvertisement__body__item">
              <span>Min Salary: </span>
              {jobAdvertisement.minSalary}$
            </div>
            <div className="jobAdvertisement__body__item">
              <span>Application Deadline: </span>
              {jobAdvertisement.applicationDeadline}
            </div>
          </div>
          <div className="jobAdvertisement__footer">
            <div className="jobAdvertisement__footer__elements jobAdvertisement__like">
              <ThumbUpIcon className="footer__icon" />
              <b>{jobAdvertisement.like}</b>
            </div>
            <Link className="link" to={`/jobAdvertisements/${jobAdvertisement.id}`}>
            <div className="jobAdvertisement__footer__elements jobAdvertisement__detail">
              <DirectionsIcon className="footer__icon" />
              <b>Go Advert</b>
            </div>
            </Link>
            <div className="jobAdvertisement__footer__elements jobAdvertisement__comment">
              <InsertCommentIcon className="footer__icon" />
              <b>45</b>
            </div>
            <div className="jobAdvertisement__footer__elements jobAdvertisement__application">
              <AssignmentIcon className="footer__icon" />
              <b>14</b>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}
export default JobAdvertisement;
