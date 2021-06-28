import React from "react";
import JobAdvertisementService from "../../services/jobAdvertisementServices/jobAdvertisementService";
import "../../styles/jobAdvertisementStyles/JobAdvertConfirmButtons.css"
import Button from '@material-ui/core/Button';
import { ButtonGroup } from "@material-ui/core";
import CheckCircleIcon from '@material-ui/icons/CheckCircle';
import CancelIcon from '@material-ui/icons/Cancel';

function JobAdvertConfirmButtons({ id }) {
  const jobAdvertisementService = new JobAdvertisementService();

  const handleConfirm = (confirm) => {
    jobAdvertisementService
      .confirmation(id, confirm)
  };

  return (
    <div className="jobAdvert__button">
      <ButtonGroup disableElevation variant="contained">
        <Button startIcon={<CheckCircleIcon />} className="jobAdvert__button--confirm" onClick={() => handleConfirm(true)}>Confirm</Button>
        <Button endIcon={<CancelIcon />} className="jobAdvert__button--deny" onClick={() => handleConfirm(false)}>Deny</Button>
      </ButtonGroup>
    </div>
  );
}

export default JobAdvertConfirmButtons;
