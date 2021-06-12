import React from "react";
import "../styles/Feed.css";
import JobAdvertisement from "../pages/JobAdvertisement";

function Feed() {
  return (
    <div className="feed">
      <div className="feed__contents">
        {/* Profile */}
        <JobAdvertisement />
        {/* Companies */}
        {/* Resume */}
        {/* Friends */}
      </div>
    </div>
  );
}

export default Feed;
