package jp.co.asia.archive.ums.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.asia.archive.ums.domain.repository.UmsDAO;

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
  public String registerConfirm(
      @RequestParam("userId") String userId,
      @RequestParam("username") String username,
      @RequestParam("birthDay") String birthDay,
      @RequestParam("address") String address,
      @RequestParam("telNum") String telNum,
      @RequestParam("password") String password,
      @RequestParam("confirmPassword") String confirmPassword,
      HttpServletRequest req) {
    //QUESTION ただのParam vs. RequestParam?
    //TODO checkboxの値も受け入れるように

    HttpSession session = req.getSession();
    session.setAttribute("userId", userId);
    session.setAttribute("username", username);
    session.setAttribute("birthDay", birthDay);
    session.setAttribute("address", address);
    session.setAttribute("telNum", telNum);
    session.setAttribute("password", password);
    session.setAttribute("confirmPassword", confirmPassword);

    return "user/registerConfirm";
  }

  @RequestMapping(value = "/register", params = "redo", method = RequestMethod.GET) //FIXME POSTに修正
  public String registerRedo() {

    return "user/registerForm";
  }

  @RequestMapping(value = "/register", method = RequestMethod.GET) //FIXME POSTに修正
  public String register(Model model, HttpServletRequest req) {

    HttpSession session = req.getSession();
    String userId = (String) session.getAttribute("userId");
    System.out.println(userId + "はsessionに入った");
    String username = (String) session.getAttribute("username");
    String birthDay = (String) session.getAttribute("birthDay");
    String address = (String) session.getAttribute("address");
    String telNum = (String) session.getAttribute("telNum");
    String password = (String) session.getAttribute("password");

    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);
    dao.register(userId, username, birthDay, address, telNum, password);

    return "redirect:/user/register?finish";
  }

  @RequestMapping(value = "/register", params = "finish", method = RequestMethod.GET)
  public String registerFinish() {

    return "user/registerFinish";
  }
}
