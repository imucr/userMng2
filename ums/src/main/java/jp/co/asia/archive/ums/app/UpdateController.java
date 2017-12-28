package jp.co.asia.archive.ums.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.asia.archive.ums.domain.model.UVO;
import jp.co.asia.archive.ums.domain.model.UVO2;
import jp.co.asia.archive.ums.domain.repository.UmsDAO;
import jp.co.asia.archive.ums.validation.UVO2Validator;
import jp.co.asia.archive.ums.validation.UVO2Validator_forUpdate;

//TODO Javadoc

@Controller
@RequestMapping("/user")
public class UpdateController {

  @Autowired private SqlSession sqlSession;

  @RequestMapping(value = "/update", params = "form", method = RequestMethod.GET)
  public String updateForm(
      HttpServletRequest req, Model model, @RequestParam("userId") String user_id) {

    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);
    UVO uvo = dao.updateList(user_id);
    model.addAttribute("updateList", uvo);

    HttpSession session = req.getSession();
    session.setAttribute("userId", user_id);
    System.out.println(user_id+"はSESSIONに入った");

    return "user/updateForm";
  }

////////////////////////
  @RequestMapping(value = "/update", params = "confirm", method = RequestMethod.GET) //FIXME POSTに
  public String updateConfirm(@ModelAttribute("uvo2") UVO uvo2, BindingResult br, HttpServletRequest req, Model model) {

	  
//	  new UVO2Validator_forUpdate().validate(uvo, br);
//	  if(br.hasErrors()){
//		  model.addAttribute("updateList", uvo);
//		  return "user/updateForm";
//	  }
	  
    HttpSession session = req.getSession();
    session.setAttribute("username", uvo2.getUsername());
    session.setAttribute("birthDay", uvo2.getBirthDay());
    session.setAttribute("address", uvo2.getAddress());
    session.setAttribute("telNum", uvo2.getTelNum());
    session.setAttribute("password", uvo2.getPassword());
    session.setAttribute("confirmPassword", uvo2.getConfirmPassword());

    return "user/updateConfirm";
  }

  @RequestMapping(value = "/update", params = "redo", method = RequestMethod.GET) //FIXME POSTに
  public String redo(HttpServletRequest req, Model model) {
	  HttpSession session=req.getSession();
	    String user_id = (String) session.getAttribute("userId");
	    UmsDAO dao=sqlSession.getMapper(UmsDAO.class);
	    UVO uvo = dao.updateList(user_id);
	    model.addAttribute("updateList", uvo);

    return "user/updateForm";
  }

  @RequestMapping(value = "/update", method = RequestMethod.GET) //FIXME POSTに
  public String update(HttpServletRequest req) {

    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");
    String username = (String) session.getAttribute("username");
    String birthDay = (String) session.getAttribute("birthDay");
    String address = (String) session.getAttribute("address");
    String telNum = (String) session.getAttribute("telNum");
    String password = (String) session.getAttribute("password");

    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yy HH:mm");
    String formattedDate = dateFormat.format(date);
    System.out.println("現在日時は" + formattedDate);

    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);
    dao.update(username, birthDay, address, telNum, password, formattedDate, userId);

    return "redirect:/user/update?finish";
  }

  @RequestMapping(value = "/update", params = "finish", method = RequestMethod.GET)
  public String updateFinish() {

    return "user/updateFinish";
  }
}
