package jp.co.asia.archive.ums.app;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


//TODO Javadoc

@Controller
public class LoginTopController {

	
     @RequestMapping(value = "/login", params="form", method = RequestMethod.GET)
      public ModelAndView loginForm() { 
	    	  ModelAndView mav=new ModelAndView();
	    	  mav.setViewName("login/loginForm");
	    	  return mav;
    }


      @RequestMapping(value = "/top", method = RequestMethod.GET) //MEMO RequestMethod.GET: URL requestがgetならこのメソッドが処理　QUESTION それでは直前のページはloginFormではないってこと？パスワードをgetに送るはずないから
      public String menu() {

        return "top/menu";
      }      
      
}
