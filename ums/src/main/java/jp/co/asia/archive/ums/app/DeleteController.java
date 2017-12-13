package jp.co.asia.archive.ums.app;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.asia.archive.ums.domain.model.UVO;
import jp.co.asia.archive.ums.domain.repository.UmsDAO;

//TODO Javadoc

@Controller
@RequestMapping("/user")
public class DeleteController {

  @Autowired private SqlSession sqlSession;

  @RequestMapping(value = "/delete", params = "form", method = RequestMethod.GET)
  public String deleteForm(
      HttpServletRequest req,
      Model model,
      @RequestParam("userId")
          String
              user_id) { //MEMO https://stackoverflow.com/questions/13213061/springmvc-requestmapping-for-get-parameters

    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);
    ArrayList<UVO> uvo = dao.deleteList(user_id);
    model.addAttribute("deleteList", uvo);

    HttpSession session = req.getSession();
    session.setAttribute("user_id", user_id);
    System.out.println("SESSIONに値入った");
    //          model.addAttribute("userIdAsParameter", user_id); //MEMO 一つのパラメーターを二カ所以上に送りたいとき、単にmodelにそれぞれ違う名前として乗せばいい

    return "user/deleteForm";
  }

  @RequestMapping(value = "/delete", params = "confirm", method = RequestMethod.GET) //FIXME POSTに
  public String deleteConfirm(Model model, HttpServletRequest req) {

    HttpSession session = req.getSession();
    String user_id = (String) session.getAttribute("user_id");

    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);
    ArrayList<UVO> uvo = dao.deleteList(user_id);
    model.addAttribute("deleteList", uvo);

    return "user/deleteConfirm";
  }

  @RequestMapping(value = "/delete", params = "redo", method = RequestMethod.GET) //FIXME POSTに
  public String redo(HttpServletRequest req, Model model) {

    HttpSession session = req.getSession();
    String user_id = (String) session.getAttribute("user_id");

    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);
    ArrayList<UVO> uvo = dao.deleteList(user_id);
    model.addAttribute("deleteList", uvo);

    return "user/deleteForm";
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET) //FIXME POSTに
  public String delete(Model model, HttpServletRequest req) {

    HttpSession session = req.getSession();
    String user_id = (String) session.getAttribute("user_id");

    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);
    dao.delete(user_id);

    return "redirect:delete?finish";
  }

  @RequestMapping(value = "/delete", params = "finish", method = RequestMethod.GET)
  public String deleteFinish(Model model, HttpServletRequest req) {

    return "user/deleteFinish";
  }
}
