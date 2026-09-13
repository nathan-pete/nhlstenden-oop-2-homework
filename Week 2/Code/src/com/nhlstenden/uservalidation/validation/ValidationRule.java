package com.nhlstenden.uservalidation.validation;

import com.nhlstenden.uservalidation.user.UserAccount;

public interface ValidationRule
{
	boolean validate(UserAccount account);
}
