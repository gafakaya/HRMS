
import React, { useEffect, useState } from "react";
import { Avatar, makeStyles } from "@material-ui/core";
import JobAdvertisementService from "../services/jobAdvertisementService";
import "../styles/JobAdvertisement.css";
import StarBorderIcon from "@material-ui/icons/StarBorder";
import StarIcon from "@material-ui/icons/Star";
import ThumbUpIcon from "@material-ui/icons/ThumbUp";
import InsertCommentIcon from "@material-ui/icons/InsertComment";
import AssignmentIcon from "@material-ui/icons/Assignment";

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
  }, [jobAdvertisements]);

  return (
    <div>
      {jobAdvertisements.map((jobAdvertisement) => (
        <div className="jobAdvertisement" key={jobAdvertisement.id}>
          <div className="jobAdvertisement__header">
            <div className="jobAdvertisement__header__company">
              <Avatar id="avatar" className={classes.large} src="" />
              <div className="jobAdvertisement__header__company_info">
                {<h4> {jobAdvertisement.companyName}</h4>}
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
          </div>
          <div className="jobAdvertisement__footer">
            <div className="jobAdvertisement__footer__elements jobAdvertisement__like">
              <ThumbUpIcon className="like__icon" />
              <h4>{jobAdvertisement.like}</h4>
            </div>
            <div className="jobAdvertisement__footer__elements jobAdvertisement__comment">
              <InsertCommentIcon className="comment__icon" />
              <h4>45</h4>
            </div>
            <div className="jobAdvertisement__footer__elements jobAdvertisement__application">
              <AssignmentIcon className="application__icon" />
              <h4>14</h4>
            </div>
          </div>
        </div>
      ))}
    </div>
  );
}
export default JobAdvertisement;
