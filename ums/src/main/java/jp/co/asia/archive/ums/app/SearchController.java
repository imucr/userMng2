package jp.co.asia.archive.ums.app;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.asia.archive.ums.domain.model.UVO;
import jp.co.asia.archive.ums.domain.repository.UmsDAO;

@Controller
@RequestMapping("/user")
public class SearchController {

	  @Autowired private SqlSession sqlSession;

    /**
     * 検索フォームへ遷移
     *
     * @return 検索フォーム画面名
     */
      @RequestMapping(value = "/search", params="form", method = RequestMethod.GET)
      public ModelAndView searchForm() {
    	  		
    	  ModelAndView mav=new ModelAndView();
    	  mav.setViewName("user/searchForm");
    	  return mav;
      //return "user/searchForm";
    }

      
      /**
       * 条件あるデータリスト出力に変更
       *
       * @return View名
       */
      @RequestMapping(value = "/search", method = RequestMethod.GET) //TODO 後でPOSTに変更予定
      public String searchList(Model model, @Param("user_id") String user_id, @Param("name") String name, @Param("birth") String birth, @Param("address") String address, @Param("pn") String pn, @Param("roles") String roles, @Param("status") String status) { //TODO Parameter無しにする
        
        UmsDAO dao=sqlSession.getMapper(UmsDAO.class);
        ArrayList<UVO> uvo = dao.list(user_id, name, birth, address, pn, roles, status); //TODO rolesを、t_roleテーブルjoinして処理
        model.addAttribute("list", uvo);

        return "user/searchList";
      }      
}
