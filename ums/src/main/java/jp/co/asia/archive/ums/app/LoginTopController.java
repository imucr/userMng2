package jp.co.asia.archive.ums.app;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.asia.archive.ums.domain.model.UVO2;
import jp.co.asia.archive.ums.domain.repository.UmsDAO;

//TODO Javadoc

@Controller
public class LoginTopController {

  @Autowired private SqlSession sqlSession;

  @RequestMapping(value = "/login", params = "form", method = RequestMethod.GET)
  public ModelAndView loginForm() {
    ModelAndView mav = new ModelAndView();
    mav.setViewName("login/loginForm");
    return mav;
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String loginCheck(@ModelAttribute("uvo2") UVO2 uvo2, HttpServletRequest req, Model model) {

    String UserId = uvo2.getUserId();
    String password = uvo2.getPassword();
    HttpSession session = req.getSession();

    if (CheckIfIdPwExist(UserId, password)) {
      session.setAttribute("LOGIN.OK", UserId);
      String check = (String) session.getAttribute("LOGIN.OK");
      System.out.println("UserId" + check + "はDBに存在していたので、セッションに入れた");
      return "top/menu";
    } else {
      return "redirect:/login?form"; //QUESTION どうして「login?form」だけ書くと作動しない？
    }
  }

  private boolean CheckIfIdPwExist(String userId, String password) {

    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);

    ArrayList<UVO2> uvo2 = dao.CheckIfIdPwExist(userId, password);
    if (uvo2.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }

  @RequestMapping(
    value = "/top",
    method = RequestMethod.GET
  ) //MEMO RequestMethod.GET: URL requestがgetならこのメソッドが処理　QUESTION それでは直前のページはloginFormではないってこと？パスワードをgetに送るはずないから
  public String menu() {

    return "top/menu";
  }

  @RequestMapping(
    value = "/logout",
    method = RequestMethod.GET
  ) //FIXME POST
  public String Logout(HttpServletRequest req) {
	  HttpSession session= req.getSession();
	  session.invalidate();
    return "redirect:/login?form";
  }
}
