package com.himedia.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.board.dto.BoardDto;
import com.himedia.board.util.Dbm;

public class BoardDao {
	private BoardDao() {
	}

	private static BoardDao itc = new BoardDao();

	public static BoardDao getInstance() {
		return itc;
	}

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public ArrayList<BoardDto> getAllBoard() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		con = Dbm.getConnection();
		String sql = "SELECT * FROM board ORDER BY num DESC";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDto bdto = new BoardDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setPass(rs.getString("pass"));
				bdto.setEmail(rs.getString("email"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				list.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
		return list;
	}

	
}
