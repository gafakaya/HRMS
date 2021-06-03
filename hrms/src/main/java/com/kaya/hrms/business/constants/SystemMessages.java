package com.kaya.hrms.business.constants;

public class SystemMessages {

    public static class Error{
        public static final String NOT_FOUND = "Entity not found.";
        public static final String EMPTY_FIELDS = "All fields must be filled.";
        public static final String EXISTS_IN_DB = "Entity already exist in database.";
    }

    public static class Crud{
        public static final String ADDED = "Added to database.";
        public static final String UPDATED = "Updated.";
        public static final String DELETED = "Deleted from database.";
        public static final String PULLED_ALL = "All pulled from database.";
        public static final String PULLED = "Pulled from database.";
    }

    public static class Verification{
        public static final String VERIFICATION_CODE_SENT = "Verification code sent.";
        public static final String USER_VERIFICATION_FAILED = "User verification failed.";
        public static final String USER_VERIFIED = "User verified.";
    }

}
