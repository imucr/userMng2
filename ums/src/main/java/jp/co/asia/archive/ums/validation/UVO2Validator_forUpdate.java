package jp.co.asia.archive.ums.validation;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import jp.co.asia.archive.ums.domain.model.UVO2;

public class UVO2Validator_forUpdate implements Validator {
	
  @Override
  public boolean supports(Class<?> arg0) {
    return UVO2.class.isAssignableFrom(arg0);
  }

  @Override
  public void validate(Object target, Errors errors) {

    UVO2 uvo2 = (UVO2) target;
    
    //username 30文字まで
    String username=uvo2.getUsername();
    if(username.length()==0 || username.length()>30){
        errors.rejectValue("username", "usernameMessage");
    }
    
    //birthDay 日付形式
    String birthDay=uvo2.getBirthDay();
    if (birthDay.matches("^[0-9]{4}/[0-9]{2}/[0-9]{2}$") == false) {
        errors.rejectValue("birthDay", "birthDayMessage");
    }
    //address 60文字まで
    String address=uvo2.getAddress();
    if(address.length()==0 || address.length()>60){
        errors.rejectValue("address", "addressMessage");
    }
    
    //telNum 数字10桁か11桁
    String telNum=uvo2.getTelNum();
    if(telNum.matches("^\\d{10,11}$") == false){
        errors.rejectValue("telNum", "telNumMessage");
    }
    
    //password 半角英数6文字以上
    String password=uvo2.getPassword();
    if(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{6,}$") == false){
    		/*
    		 ”0～9のいずれかを含む”かつ
		”a～zのいずれかを含む”かつ
		”A～Zのいずれかを含む”、
		0～9、a～z、A～Z、ハイフンのいずれかで構成された6文字以上の文字列
    		 */
        errors.rejectValue("password", "passwordMessage");
    }
    
    //confirmPassword
    String confirmPassword=uvo2.getConfirmPassword();
    if(!confirmPassword.equals(password)){ //QUESTIOM password変数を何気なく使うことができる理由？ ANSWER 同一位置
        errors.rejectValue("confirmPassword", "confirmPasswordMessage");
    }
    
    //	  UVO2 uvo2 =(UVO2) target;
    //
    //	  String userId=uvo2.getUserId();
    //	  if(userId==null||userId.trim().isEmpty()){
    //		  errors.rejectValue("userId", "empty");
  }
}
