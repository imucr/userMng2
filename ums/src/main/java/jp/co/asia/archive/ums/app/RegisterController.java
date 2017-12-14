package jp.co.asia.archive.ums.app;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




//TODO Javadoc

@Controller
@RequestMapping("/user")
public class RegisterController {

      @RequestMapping(value = "/register", params="form", method = RequestMethod.GET)
      public String registerForm() {

        return "user/registerForm";
      }      

      
//臨時
      @RequestMapping(value = "/register", params="confirm", method = RequestMethod.GET) //FIXME POSTに修正
      public String registerConfirm(HttpServletRequest req, @RequestParam(value="roles", required=false) String roles) { //FIXME parameterなしに
    	  
    	  HttpSession session=req.getSession();
    	  session.setAttribute("roles", roles);

    	    System.out.println(roles+"はSESSIONに入った");

        return "user/registerConfirm";
      }          
        
      
/*checkbox処理方法知るまで保留
      @RequestMapping(value = "/register", params="confirm", method = RequestMethod.GET) //FIXME POSTに修正
      public String registerConfirm(Model model, @RequestParam("userId") String userId, @RequestParam("username") String username, @RequestParam("birthDay") String birthDay, @RequestParam("address") String address, @RequestParam("telNum") String telNum, @RequestParam("roles") String roles, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword, HttpServletRequest req) {
    	  	//QUESTION ただのParam vs. RequestParam?
    	  
////param場合
//  	    System.out.println(aaa+"はparamを通じて来た");
//  	    model.addAttribute("userId", aaa);
    	  
//Session場合    	  

    	  HttpSession session=req.getSession();
    	  session.setAttribute("userId", userId);
    	    System.out.println(userId+"はSESSIONに入った");
    	  
        return "user/registerConfirm";
      }          

*/
      @RequestMapping(value = "/register", params="redo", method = RequestMethod.GET) //FIXME POSTに修正
      public String registerRedo() {

        return "user/registerForm";
      }         

      
      @RequestMapping(value = "/register", method = RequestMethod.GET) //FIXME POSTに修正
      public String register() {

    	  	return "redirect:/user/register?finish"; //QUESTION redirectとは？
      }   
      
      @RequestMapping(value = "/register", params="finish", method = RequestMethod.GET)
      public String registerFinish() {

        return "user/registerFinish";
      }     
      
}
