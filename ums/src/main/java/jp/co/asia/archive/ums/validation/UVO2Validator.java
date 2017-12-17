package jp.co.asia.archive.ums.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import jp.co.asia.archive.ums.domain.model.UVO2;

public class UVO2Validator implements Validator {

  @Override
  public boolean supports(Class<?> arg0) {
    return UVO2.class.isAssignableFrom(arg0);
  }

  @Override
  public void validate(Object target, Errors errors) {
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "empty");

    //	  UVO2 uvo2 =(UVO2) target;
    //
    //	  String userId=uvo2.getUserId();
    //	  if(userId==null||userId.trim().isEmpty()){
    //		  errors.rejectValue("userId", "empty");
  }
}
