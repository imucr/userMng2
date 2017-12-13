package jp.co.asia.archive.ums.domain.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import jp.co.asia.archive.ums.domain.model.UVO;

public interface UmsDAO{
	public ArrayList<UVO>list(@Param("user_id") String user_id, @Param("name") String name, @Param("birth") String birth, @Param("address") String address, @Param("pn") String pn, @Param("status") String status, @Param("updated") String updated);
		//MEMO Parameter 'パラメーター名' not found. Available parameters are [1, 0, param1, param2]...: パラメーターマッピングできなくて生じる問題。@Paramを使えば解決。ただ宣言だけしておくとどこから来たか分からないから当然。

}
