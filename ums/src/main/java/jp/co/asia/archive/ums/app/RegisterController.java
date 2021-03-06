package jp.co.asia.archive.ums.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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

  private List<String> getList(){
	  List<String> list=(List<String>) new ArrayList<String>();
	  list.add("ADMIN");
	  list.add("USER");
	  return list;
	 
  }
  
  @RequestMapping(value = "/register", params = "form", method = RequestMethod.GET)
  public String registerForm(Model model) {
	  UVO2 uvo2 = new UVO2();
	  model.addAttribute("uvo2", uvo2); //QUESTION これはこの段階でなんで必要なんだろう。書かないとエラー出る。
	  model.addAttribute("checkItems", getList());
    return "user/registerForm";
  }

  @RequestMapping(
    value = "/register",
    params = "confirm",
    method = RequestMethod.GET
  ) //FIXME POSTに修正
  public String registerConfirm(@ModelAttribute UVO2 uvo2, BindingResult br, HttpServletRequest req) {
    //QUESTION ただのParam vs. RequestParam?
	//QUESTION ModelAttributeは単にコマンドオブジェクト名を短くする機能だけではないみたい。これつけないとViewでエラーメッセージ出ない
    //TODO checkboxの値も受け入れるように

//	  new UVO2Validator().validate(uvo2, br);
//	  if(br.hasErrors()){
//		  return "user/registerForm";
//	  }
	  
    HttpSession session = req.getSession();
    session.setAttribute("userId", uvo2.getUserId());
    session.setAttribute("username", uvo2.getUsername());
    session.setAttribute("birthDay", uvo2.getBirthDay());
    session.setAttribute("address", uvo2.getAddress());
    session.setAttribute("telNum", uvo2.getTelNum());

    //String selected = Arrays.toString(uvo2.getRoles());

    String[] items = uvo2.getRoles();

    for (int i=0; i<items.length; i++){
    		System.out.println("配列の中身は"+items[i]); 
    }
    
//    ＊参考
//    for (int i = 0;i > items.length; i ++) {
//	  System.out.println(items[i]);
//	}
  
    session.setAttribute("roles", items);
    
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
    
    String[] roles_dontUse = (String[]) session.getAttribute("roles");
    String roles=Arrays.toString(roles_dontUse); //FIXME ADMIN, USER全部選んだ場合、DBに別の行として入られるように
    
    String password = (String) session.getAttribute("password");

    // MEMO Q. How to get client current date and time in server side ??? A. Get the time from the client side and send it to server. →全然効かない
    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("M/dd/yy HH:mm");
    String formattedDate = dateFormat.format(date);
    		System.out.println("現在日時は"+formattedDate);
    		
    
    UmsDAO dao = sqlSession.getMapper(UmsDAO.class);
    dao.register(userId, username, birthDay, address, telNum, password, formattedDate);
    dao.roleRegister(userId, roles);// FIXME 配列の内容を分けて入れるように
    return "redirect:/user/register?finish";
  }

  @RequestMapping(value = "/register", params = "finish", method = RequestMethod.GET)
  public String registerFinish() {

    return "user/registerFinish";
  }
}
