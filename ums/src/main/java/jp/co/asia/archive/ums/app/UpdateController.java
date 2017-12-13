package jp.co.asia.archive.ums.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




//TODO Javadoc

@Controller
@RequestMapping("/user")
public class UpdateController {

      @RequestMapping(value = "/update", params="formUserId", method = RequestMethod.GET) //FIXME form&userId=xyzに
      public String updateForm() {

        return "user/updateForm";
      }      

      @RequestMapping(value = "/update", params="confirm", method = RequestMethod.GET) //FIXME POSTに
      public String updateConfirm() {

        return "user/updateConfirm";
      }   

      @RequestMapping(value = "/update", params="redo", method = RequestMethod.GET) //FIXME POSTに
      public String redo() {

        return "user/updateForm";
      }         
      
      @RequestMapping(value = "/update", method = RequestMethod.GET) //FIXME POSTに
      public String update() {

    	  	return "redirect:/user/update?finish";
      }   

      @RequestMapping(value = "/update", params="finish", method = RequestMethod.GET)
      public String updateFinish() {

        return "user/updateFinish";
      }   
       
      
}
