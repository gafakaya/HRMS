import React from "react";
import "../styles/AddJobAdvertisement.css";

function AddJobAdvertisement() {
  return (
    <div className="addJobAdvertisement">
      <div className="addJobAdvertisement__header">
        <h3>Job Advertisement</h3>
      </div>
      <div className="addJobAdvertisement__body">
        <div className="addJobAdvertisement__body__description">
          {/* label */}
          {/* textarea */}
        </div>
        <div className="addJobAdvertisement__body__items">
          <div className="addJobAdvertisement__body__section"></div>
          <div className="addJobAdvertisement__body__section"></div>
        </div>
      </div>
    </div>
  );
}

export default AddJobAdvertisement;
