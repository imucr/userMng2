package jp.co.asia.archive.ums.app;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




//TODO Javadoc

@Controller
@RequestMapping("/user")
public class RegisterController {

      @RequestMapping(value = "/register", params="form", method = RequestMethod.GET)
      public String registerForm() {

        return "user/registerForm";
      }      

      @RequestMapping(value = "/register", params="confirm", method = RequestMethod.GET) //FIXME POSTに修正
      public String registerConfirm() {
        return "user/registerConfirm";
      }          

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
