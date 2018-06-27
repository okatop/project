package com.indiya.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.indiya.member.model.MemberDto;
import com.indiya.member.model.ZipDto;
import com.indiya.util.db.DBClose;
import com.indiya.util.db.DBConnection;

public class MemberDaoImpl implements MemberDao {

	@Override
	public int idCheck(String id) {
		int cnt = 1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DBConnection.makeConnection();
			String sql = "";
			sql += "select count(id) cnt \n";
			sql += "from member \n";
			sql += "where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
		} catch (SQLException e) {
			cnt=1;
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		
		return cnt;
	}

	@Override
	public List<ZipDto> zipSearch(String dong) {
		List<ZipDto> list = new ArrayList<ZipDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn=DBConnection.makeConnection();
			String sql = "";
			sql += "select zipcode, sido || ' ' || gugun || ' ' || doro as address \n";
			sql += "from zipcode \n";
			sql += "where doro like '%'||?||'%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dong);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipDto zipDto = new ZipDto();
				zipDto.setZipcode(rs.getString("zipcode"));
				zipDto.setAddress(rs.getString("address"));
				
				list.add(zipDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt);
		}
		return list;
	}

	@Override
	public int registerMember(MemberDto memberDto) {
		int cnt= 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "insert \n";
			sql += "	into bmember (name, id, pass, email1, email2, zipcode, addr1, addr2, tel1, tel2, tel3) \n";
			sql += "	values (?, member_seq.nextval, ?, ?, ?, ?, ?,?,?,?,?) \n";
			sql += "select * from dual";
			pstmt = conn.prepareStatement(sql);
			int idx = 0;
			pstmt.setString(++idx, memberDto.getName());
			pstmt.setString(++idx, memberDto.getId());
			pstmt.setString(++idx, memberDto.getPass());
			pstmt.setString(++idx, memberDto.getEmail1());
			pstmt.setString(++idx, memberDto.getEmail2());
			pstmt.setString(++idx, memberDto.getZipcode());
			pstmt.setString(++idx, memberDto.getAddr1());
			pstmt.setString(++idx, memberDto.getAddr2());
			pstmt.setString(++idx, memberDto.getTel1());
			pstmt.setString(++idx, memberDto.getTel2());
			pstmt.setString(++idx, memberDto.getTel3());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public MemberDto getMember(String id) {
		return null;
	}

	@Override
	public int modifyMember(MemberDto memberDto) {
		return 0;
	}

	@Override
	public void deleteMember(String id) {
	}

	@Override
	public MemberDto login(Map<String, String> map) {
		MemberDto memberDto =null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.makeConnection();
			String sql = "";
			sql += "select id, name \n";
			sql += "from member \n";
			sql += "where id = ? and pass = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpass"));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return memberDto;
	}
}