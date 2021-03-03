package com.webjjang.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.webjjang.notice.vo.NoticeVO;
import com.webjjang.util.PageObject;
import com.webjjang.util.db.DBInfo;
import com.webjjang.util.db.DBSQL;

public class NoticeDAO {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<NoticeVO>list(PageObject pageObject) throws Exception{
		List<NoticeVO> list = null;
		
		try {
			con=DBInfo.getConnection();
			pstmt=con.prepareStatement(DBSQL.NOTICE_LIST);
			pstmt.setLong(1, pageObject.getStartRow());
			pstmt.setLong(2, pageObject.getEndRow());
			rs = pstmt.executeQuery();
			if(rs!=null) {
				while(rs.next()){
					if(list==null) list = new ArrayList<NoticeVO>(); 
					NoticeVO vo = new NoticeVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setStartDate(rs.getString("startDate"));
					vo.setEndDate(rs.getString("endDate"));
					vo.setUpdateDate(rs.getString("updateDate"));
					
					list.add(vo);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("공지사항 목록  DB 처리중 오류");
		}finally {
			DBInfo.close(con, pstmt, rs);
		}
		
		return list;
	}
	
	public long getTotalRow() throws Exception{
		long result = 0;
		try {
			con=DBInfo.getConnection();
			System.out.println("BoardDAO.getTotlaRow().con : " + con);
			pstmt= con.prepareStatement(DBSQL.NOTICE_GET_TOTALROW);
			System.out.println("BoardDAO.getTotlaRow().pstmt : " + pstmt);
			rs=pstmt.executeQuery();
			System.out.println("BoardDAO.getTotlaRow().rs : " + rs);
			
			//rs출력은 가능하나 rs.next()는 데이터가 넘어가므로 안됨 
			if(rs!=null && rs.next()) {
				result = rs.getLong(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
;		throw new Exception("공지사항 전제 갯수 가져오는  DB처리중 오류");
		}finally {
			DBInfo.close(con, pstmt,rs);
		}
		System.out.println("NoticeDAO.getTotlaRow().result : " + result);
		return result;
	}
}
