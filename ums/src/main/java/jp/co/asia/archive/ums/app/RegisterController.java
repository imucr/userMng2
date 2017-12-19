package jp.co.asia.archive.ums.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.asia.archive.ums.domain.model.UVO2;
import jp.co.asia.archive.ums.domain.repository.UmsDAO;
import jp.co.asia.archive.ums.validation.UVO2Validator;

@Controller
@RequestMapping("/user")
public class RegisterController {

  @Autowired private SqlSession sqlSession;

  @RequestMapping(value = "/register", params = "form", method = RequestMethod.GET)
  public String registerForm() {

    return "user/registerForm";
  }

  @RequestMapping(
    value = "/register",
    params = "confirm",
    method = RequestMethod.GET
  ) //FIXME POSTに修正
  public String registerConfirm(@ModelAttribute("uvo2") UVO2 uvo2, BindingResult br, HttpServletRequest req) {
    //QUESTION ただのParam vs. RequestParam?
	//QUESTION ModelAttributeは単にコマンドオブジェクト名を短くする機能だけではないみたい。これつけないとViewでエラーメッセージ出ない
    //TODO checkboxの値も受け入れるように

	  new UVO2Validator().validate(uvo2, br);
	  if(br.hasErrors()){
		  return "user/registerForm";
	  }
	  
    HttpSession session = req.getSession();
    session.setAttribute("userId", uvo2.getUserId());
    session.setAttribute("username", uvo2.getUsername());
    session.setAttribute("birthDay", uvo2.getBirthDay());
    session.setAttribute("address", uvo2.getAddress());
    session.setAttribute("telNum", uvo2.getTelNum());
    session.setAttribute("password", uvo2.getPassword());
    session.setAttribute("confirmPassword", uvo2.getConfirmPassword());

    return "user/registerConfirm";
  }

  @RequestMapping(value = "/register", params = "redo", method = RequestMethod.GET) //FIXME POSTに修正
  public String registerRedo() {

    return "user/registerForm";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET) //FIXME POSTに修正
  public String register(Model model, HttpServletRequest req, Locale locale) {

    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");
    System.out.println(userId + "はsessionに入った");
    String username = (String) session.getAttribute("username");
    String birthDay = (String) session.getAttribute("birthDay");
    String address = (String) session.getAttribute("address");
    String telNum = (String) session.getAttribute("telNum");
    String password = (String) session.getAttribute("password");

    // MEMO Q. How to get client current date and time in server side ??? A. Get the time from the client side and send it to server. →全然効かない
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yy HH:mm");
    String formattedDate = dateFormat.format(date);
    		System.out.println("現在日時は"+formattedDate);
    		
    
    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);
    dao.register(userId, username, birthDay, address, telNum, password, formattedDate);

    return "redirect:/user/register?finish";
  }

  @RequestMapping(value = "/register", params = "finish", method = RequestMethod.GET)
  public String registerFinish() {

    return "user/registerFinish";
  }
}
