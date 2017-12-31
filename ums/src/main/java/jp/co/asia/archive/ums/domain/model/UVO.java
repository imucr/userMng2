package jp.co.asia.archive.ums.domain.model;

public class UVO {
  String user_id;
  String name;
  String birth;
  String address;
  String pn;
  String pw;
  String status;
  String updated;

  public UVO() {}

  public UVO(
      String user_id,
      String name,
      String birth,
      String address,
      String pn,
      String pw,
      String status,
      String updated) {
    super();
    this.user_id = user_id;
    this.name = name;
    this.birth = birth;
    this.address = address;
    this.pn = pn;
    this.pw = pw;
    this.status = status;
    this.updated = updated;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPn() {
    return pn;
  }

  public void setPn(String pn) {
    this.pn = pn;
  }

  public String getPw() {
    return pw;
  }

  public void setPw(String pw) {
    this.pw = pw;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }
}
