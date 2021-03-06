import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Avatar, makeStyles } from "@material-ui/core";
import "../../styles/companyStyles/Company.css"
import CompanyService from "../../services/companyService";
import EventAvailableIcon from "@material-ui/icons/EventAvailable";
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

function Company() {
  const classes = useStyles();
  const [companies, setCompanies] = useState([]);

  useEffect(() => {
    let companyService = new CompanyService();
    companyService
      .getCompanies()
      .then((result) => setCompanies(result.data.data));
  }, []);

  return (
    <div>
      {companies.map((company) => (
        <div className="company" key={company.id}>
          <div className="company__body">
            <div className="company__body__parts">
              <div className="company_avatarAndName">
                <Avatar id="avatar" className={classes.large} src="" />
                <b className="companyName">{company.companyName}</b>
              </div>
              <div><b>Web Site: </b><i>{company.webSite}</i></div>
            </div>
            <div className="company__body__parts">
              <div><b className="email__text">Email: </b><i>{company.email}</i></div>
              <div><b>Phone Number: </b><i>{company.phone}</i></div>
            </div>
          </div>
          <div className="company__footer">
            <div className="company__footer__items">
              <EventAvailableIcon />
              <b className="company__footer__item">12</b>
            </div>
            <div className="company__footer__items">
              <AssignmentIcon />
              <b className="company__footer__item">12</b>
            </div>
            <Link className="link" to={`/company/${company.id}`}>
            <div className="jobAdvertisement__footer__elements jobAdvertisement__detail">
              <DirectionsIcon className="footer__icon" />
              <b>Go Advert</b>
            </div>
            </Link>
          </div>
        </div>
      ))}
    </div>
  );
}

export default Company;
