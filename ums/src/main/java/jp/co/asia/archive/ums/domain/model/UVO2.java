package jp.co.asia.archive.ums.domain.model;

//MEMO Validationのためのコマンドオブジェクト
public class UVO2 {
  private String userId;
  private String username;
  private String birthDay;
  private String address;
  private String telNum;
  private String password;
  private String confirmPassword;

  public UVO2() {}

  public UVO2( //QUESTION このコードのままでは、オブジェクト生成と同時にパラメターを入れなければならないんじゃない？でもなんでそうしなくてもよく作動するんだろう
      String userId,
      String username,
      String birthDay,
      String address,
      String telNum,
      String password,
      String confirmPassword) {
    super();
    this.userId = userId;
    this.username = username;
    this.birthDay = birthDay;
    this.address = address;
    this.telNum = telNum;
    this.password = password;
    this.confirmPassword = confirmPassword;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(String birthDay) {
    this.birthDay = birthDay;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getTelNum() {
    return telNum;
  }

  public void setTelNum(String telNum) {
    this.telNum = telNum;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
}