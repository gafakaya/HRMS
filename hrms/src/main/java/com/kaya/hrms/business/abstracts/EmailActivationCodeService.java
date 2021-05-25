package com.kaya.hrms.business.abstracts;

import com.kaya.hrms.core.utilities.results.Result;

public interface EmailActivationCodeService {
    Result getById(Integer id, String activationCode);
}
