package com.webjjang.notice.service;


import com.webjjang.main.controller.Service;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.util.PageObject;

public class NoticeListService implements Service {

	
		//dao 필요, 생성 후 넣어줌 -> 1.생성자 2.setter()
		NoticeDAO dao;
			
		
		@Override
		public Object service(Object obj) throws Exception {
			// TODO Auto-generated method stub
			int totalRow = (int) dao.getTotalRow();
			 PageObject pageObject = (PageObject)obj;
			 pageObject.setTotalRow(totalRow);
			 System.out.println("BoardListService.pageObject : " + pageObject);
			return dao.list(pageObject);
		}
	
		@Override
		public void setDAO(Object dao) {
			// TODO Auto-generated method stub
			this.dao = (NoticeDAO)dao;
		}
	}
