package jp.co.asia.archive.ums.app;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.asia.archive.ums.domain.model.UVO2;
import jp.co.asia.archive.ums.domain.repository.UmsDAO;

@Controller
@RequestMapping("/password")
public class PasswordChangeController {

	@Autowired private SqlSession sqlSession;

  @RequestMapping(value = "/change", params = "form", method = RequestMethod.GET)
  public String passwordChangeForm() {
	  return "password/changeForm";
  }

  @RequestMapping(value = "/change", method = RequestMethod.GET) //FIXME POST
  public String passwordChange(@ModelAttribute("uvo2") UVO2 uvo2, HttpServletRequest req) {
	  
	  //処理
	    HttpSession session = req.getSession();
	    
	    String password=uvo2.getPassword();
	    String userId = (String) session.getAttribute("LOGIN.OK");

	    Date date = new Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yy HH:mm");
	    String formattedDate = dateFormat.format(date);

	    System.out.println("DBに行くあたいは"+password+"、"+formattedDate+"、"+userId); 
	    
	    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);
	    dao.passwordUpdate(password, formattedDate, userId);
	    
	  return "redirect:/password/change?finish"; //MEMO 仕様書には「/へリダイレクト」。
  }

  @RequestMapping(value = "/change", params = "finish", method = RequestMethod.GET)
  public String changeFinish() {

    return "password/passwordFinish";
  }  
}
