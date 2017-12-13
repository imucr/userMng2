package jp.co.asia.archive.ums.domain.repository;

import java.util.ArrayList;


import jp.co.asia.archive.ums.domain.model.UVO;

public interface UmsDAO{

	public ArrayList<UVO>deleteList(String user_id);
	
	public void delete(String user_id);

}
