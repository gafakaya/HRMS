import React from "react";
import "../styles/Feed.css";
import JobAdvertisement from "../pages/JobAdvertisement";
import { Route } from "react-router";
import Company from "../pages/Company";

function Feed() {
  return (
    <div className="feed">
      {/* //TODO: Route !!! */}
      <div className="feed__contents">
        {/* Profile */}
{/* ------------------------------------------------------------------------------------ */}
        <Route exact path="/" component={JobAdvertisement} />
        <Route exact path="/jobAdvertisements" component={JobAdvertisement} />
{/* ------------------------------------------------------------------------------------ */}
        <Route exact path="/companies" component={Company} />
{/* ------------------------------------------------------------------------------------ */}
        {/* Resume */}
{/* ------------------------------------------------------------------------------------ */}
        {/* Friends */}
        {/* <Route path="/products/:name" component={ProductDetail} />
        <Route path="/cart" component={CartDetail} /> */}
      </div>
    </div>
  );
}

export default Feed;
