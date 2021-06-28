import React, { useEffect, useState } from "react";
import "../../styles/eventStyles/Event.css";
// import FlipMove from "react-flip-move";
import EventService from "../../services/eventService";

function Event() {
  const [events, setEvents] = useState([]);

  useEffect(() => {
    let eventService = new EventService();
    eventService
      .getEventsOrderByDateOfEventPaged()
      .then((result) => setEvents(result.data.data));
  }, []);

  return (
    <div className="event">
      <div className="event__header">
        <h3>Current events</h3>
      </div>

      {/* <FlipMove> */}
        <div className="event__body">
          {events.map((event) => (
            <div className="event__content" key={event.eventId}>
              <div className="event__name">{event.eventName}</div>
              <div className="event__content__body">
                <div className="company__name">{event.company.companyName}</div>
                <div className="event__date">
                  {new Date(event.dateOfEvent).getDate("en-US")}:
                  {new Date(event.dateOfEvent).getMonth("en-US") < 10
                    ? "0" + new Date(event.dateOfEvent).getMonth("en-US")
                    : new Date(event.dateOfEvent).getMonth("en-US")}
                  :{new Date(event.dateOfEvent).getFullYear("en-US")}-
                  {new Date(event.dateOfEvent).toLocaleTimeString("en-US")}
                </div>
              </div>
            </div>
          ))}
        </div>
      {/* </FlipMove> */}
    </div>
  );
}

export default Event;
