package jp.co.asia.archive.ums.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




//TODO Javadoc

@Controller
@RequestMapping("/user")
public class DeleteController {

      @RequestMapping(value = "/delete", params="formUserId", method = RequestMethod.GET) //FIXME form&userId=xyzに
      public String deleteForm() {

        return "user/deleteForm";
      }      

      @RequestMapping(value = "/delete", params="confirm", method = RequestMethod.GET) //FIXME POSTに
      public String deleteConfirm() {

        return "user/deleteConfirm";
      }   

      @RequestMapping(value = "/delete", params="redo", method = RequestMethod.GET) //FIXME POSTに
      public String redo() {

        return "user/deleteForm";
      }         
      
      @RequestMapping(value = "/delete", method = RequestMethod.GET) //FIXME POSTに
      public String delete() {

    	  	return "redirect:/user/delete?finish";
      }   

      @RequestMapping(value = "/delete", params="finish", method = RequestMethod.GET)
      public String deleteFinish() {

        return "user/deleteFinish";
      }   
      
 
       
      
}
