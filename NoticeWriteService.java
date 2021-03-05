package com.webjjang.notice.service;


import com.webjjang.main.controller.Service;
import com.webjjang.notice.dao.NoticeDAO;
import com.webjjang.notice.vo.NoticeVO;


public class NoticeWriteService implements Service {

	
		//dao 필요, 생성 후 넣어줌 -> 1.생성자 2.setter()
		private NoticeDAO dao;
			
		
		//넘어오는 데이터 : NoticeVO => obj
		@Override
		public Object service(Object obj) throws Exception {
			// TODO Auto-generated method stub
			
			return dao.write((NoticeVO)obj);
		}
	
		@Override
		
		public void setDAO(Object dao) {
			// TODO Auto-generated method stub
			this.dao = (NoticeDAO)dao;
		}
	}
