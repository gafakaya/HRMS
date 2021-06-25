import { useField } from "formik";
import React from "react";
import { Dropdown, Label } from "semantic-ui-react";

function JobHubDropdown({ ...props }) {
  const [field, meta] = useField(props);

  return (
    <div>
      <Dropdown className="jobHub__dropdown" {...field} {...props} fluid search selection />
      <div>
        {meta.touched && !!meta.error ? (
          <Label className="jobHub__Error" pointing="left" basic color="red" content={meta.error}></Label>
        ) : null}
      </div>
    </div>
  );
}

export default JobHubDropdown;
