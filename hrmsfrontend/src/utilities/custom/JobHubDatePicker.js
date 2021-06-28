import DateFnsUtils from "@date-io/date-fns";
import {
  KeyboardDatePicker,
  MuiPickersUtilsProvider,
} from "@material-ui/pickers";
import { useField } from "formik";
import React from "react";
import { Label } from "semantic-ui-react";

function JobHubDatePicker({ ...props }) {
  const [field, meta] = useField(props);

  return (
    <div>
      <MuiPickersUtilsProvider utils={DateFnsUtils}>
        <KeyboardDatePicker
          margin="normal"
          format="yyyy-MM-dd"
          KeyboardButtonProps={{
            "aria-label": "change date",
          }}
          {...field}
          {...meta}
        />
      </MuiPickersUtilsProvider>
      <div>
        {meta.touched && !!meta.error ? (
          <Label
            className="jobHub__Error"
            pointing="left"
            basic
            color="red"
            content={meta.error}
          ></Label>
        ) : null}
      </div>
    </div>
  );
}

export default JobHubDatePicker;
