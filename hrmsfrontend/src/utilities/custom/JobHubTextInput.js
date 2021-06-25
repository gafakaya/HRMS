import { useField } from "formik";
import React from "react";
import { Label } from "semantic-ui-react";
import "../../styles/JobHubFormElements.css";

function JobHubTextInput({ ...props }) {
  const [field, meta] = useField(props);

  return (
    <div className="jobHub__input">
      <input className="jobHub__input--text" {...field} {...props} />
      <div>
        {meta.touched && !!meta.error ? (
          <Label
            className="jobHub__Error"
            pointing
            basic
            content={meta.error}
            color="red"
          ></Label>
        ) : null}
      </div>
    </div>
  );
}

export default JobHubTextInput;
