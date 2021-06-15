import React from "react";
import "../styles/Feed.css";
import JobAdvertisement from "../pages/JobAdvertisement";
import { Route } from "react-router";
import Company from "../pages/Company";
import AddJobAdvertisement from "../pages/AddJobAdvertisement";

function Feed() {
  return (
    <div className="feed">
      {/* //TODO: Route !!! */}
      <div className="feed__contents">
        {/* Profile */}
        {/* ------------------------------------------------------------------------------------ */}
        <Route exact path="/" component={JobAdvertisement} />
        <Route exact path="/jobadvertisements" component={JobAdvertisement} />
        {/* ------------------------------------------------------------------------------------ */}
        <Route exact path="/companies" component={Company} />
        {/* ------------------------------------------------------------------------------------ */}
        {/* Resume */}
        {/* ------------------------------------------------------------------------------------ */}
        {/* Friends */}
        {/* ------------------------------------------------------------------------------------ */}
        {/* Add Job Advertisement */}
        <Route
          exact
          path="/addjobadvertisements"
          component={AddJobAdvertisement}
        />
        {/* <Route path="/products/:name" component={ProductDetail} />
        <Route path="/cart" component={CartDetail} /> */}
      </div>
    </div>
  );
}

export default Feed;
