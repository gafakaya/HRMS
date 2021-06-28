import React from "react";
import { Route } from "react-router";
import "../styles/Feed.css";
import JobSeekerProfile from "../pages/jobSeekerPages/JobSeekerProfile"
import JobAdvertisement from "../pages/jobAdvertisementPages/JobAdvertisement";
import Company from "../pages/companyPages/Company";
import AddJobAdvertisement from "../pages/jobAdvertisementPages/AddJobAdvertisement";
import ConfirmJobAdvertisement from "../pages/jobAdvertisementPages/ConfirmJobAdvertisement";
import JobAdvertisementDetail from "../pages/jobAdvertisementPages/JobAdvertisementDetail";
import CompanyDetail from "../pages/companyPages/CompanyDetail";
import Education from "../pages/jobSeekerPages/Education";
import Workplace from "../pages/jobSeekerPages/Workplace";
import EventList from "../pages/eventPages/EventList"

function Feed() {
  return (
    <div className="feed">
      <div className="feed__contents">
        <Route exact path="/jobseeker/:3/profile" component={JobSeekerProfile} />
        <Route exact path="/jobseeker/:3/education" component={Education} />
        <Route exact path="/jobseeker/:3/workplaces" component={Workplace} />
        {/* ------------------------------------------------------------------------------------ */}
        <Route exact path="/" component={JobAdvertisement} />
        <Route exact path="/jobadvertisements" component={JobAdvertisement} />
        {/* ------------------------------------------------------------------------------------ */}
        <Route exact path="/companies" component={Company} />
        {/* ------------------------------------------------------------------------------------ */}
        {/* Resume */}
        {/* ------------------------------------------------------------------------------------ */}
        {/* Events */}
        <Route exact path="/events" component={EventList} />

        {/* ------------------------------------------------------------------------------------ */}
        {/* Notifications */}
        {/* ------------------------------------------------------------------------------------ */}
        {/* Messages */}
        {/* ------------------------------------------------------------------------------------ */}
        <Route
          exact
          path="/jobadvertisement/add"
          component={AddJobAdvertisement}
        />
        <Route
          exact
          path="/jobadvertisement/confirm"
          component={ConfirmJobAdvertisement}
        />
        <Route
          exact
          path="/jobadvertisements/:id"
          component={JobAdvertisementDetail}
        />
        <Route path="/company/:id" component={CompanyDetail} />

        {/* <Route path="/products/:name" component={ProductDetail} />
        <Route path="/cart" component={CartDetail} /> */}
      </div>
    </div>
  );
}

export default Feed;
