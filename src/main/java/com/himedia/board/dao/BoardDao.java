package com.himedia.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.himedia.board.dto.BoardDto;
import com.himedia.board.dto.ReplyDto;
import com.himedia.board.util.Dbm;
import com.himedia.board.util.Paging;

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

	public ArrayList<BoardDto> getAllBoard(Paging paging) {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>();
		con = Dbm.getConnection();
		// String sql = "SELECT * FROM board ORDER BY num DESC";
		String sql = "SELECT * FROM board ORDER BY num DESC LIMIT ? OFFSET ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, paging.getDisplayRow());
			pstmt.setInt(2, paging.getStartNum()-1);
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
				bdto.setImage(rs.getString("image"));
				bdto.setSavefilename(rs.getString("savefilename"));
				list.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
		return list;
	}

	public int insertBoard(BoardDto bdto) {
		int result =0;
		con = Dbm.getConnection();
		String sql = "INSERT INTO board(userid, pass, email, title, content, image, savefilename) values(?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getUserid());
			pstmt.setString(2, bdto.getPass());
			pstmt.setString(3, bdto.getEmail());
			pstmt.setString(4, bdto.getTitle());
			pstmt.setString(5, bdto.getContent());
			pstmt.setString(6, bdto.getImage());
			pstmt.setString(7, bdto.getSavefilename());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
		return result;
	}

	public BoardDto getBoard(int num) {
		BoardDto bdto = null;
		con = Dbm.getConnection();
		String sql = "SELECT * FROM board WHERE num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bdto = new BoardDto();
				bdto.setNum(rs.getInt("num"));
				bdto.setPass(rs.getString("pass"));
				bdto.setEmail(rs.getString("email"));
				bdto.setUserid(rs.getString("userid"));
				bdto.setTitle(rs.getString("title"));
				bdto.setContent(rs.getString("content"));
				bdto.setReadcount(rs.getInt("readcount"));
				bdto.setWritedate(rs.getTimestamp("writedate"));
				bdto.setImage(rs.getString("image"));
				bdto.setSavefilename(rs.getString("savefilename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
//		System.out.println(bdto.toString());
		return bdto;
	}

	public void plusReadCount(int num) {
		con = Dbm.getConnection();
		String sql = "UPDATE board SET readcount = readcount+1 WHERE num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
	}

	

	public void updateBoard(BoardDto bdto) {
		con = Dbm.getConnection();
		String sql = "UPDATE board SET pass=?, email=?, title=?, content=?, image=?, savefilename=? WHERE num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bdto.getPass());
			pstmt.setString(2, bdto.getTitle());
			pstmt.setString(3, bdto.getEmail());
			pstmt.setString(4, bdto.getContent());
			pstmt.setString(5, bdto.getImage());
			pstmt.setString(6, bdto.getSavefilename());
			pstmt.setInt(7, bdto.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
	}

	public void deleteBoard(int num) {
		con = Dbm.getConnection();
		String sql = "DELETE FROM board WHERE num=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
	}

	public ArrayList<ReplyDto> getReply(int num) {
		ArrayList<ReplyDto>list = new ArrayList<ReplyDto>();
		con = Dbm.getConnection();
		String sql = "SELECT * FROM reply WHERE boardnum=? ORDER BY replynum desc";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyDto rdto = new ReplyDto();
				rdto.setReplynum(rs.getInt("replynum"));
				rdto.setBoardnum(rs.getInt("boardnum"));
				rdto.setUserid(rs.getString("userid"));
				rdto.setContent(rs.getString("content"));
				rdto.setWritedate(rs.getTimestamp("writedate"));
				//System.out.println(rdto.toString());
				list.add(rdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			Dbm.close(con, pstmt, rs);
		}
		
		return list;
	}

	public void insertReply(ReplyDto rdto) {
		con = Dbm.getConnection();
		String sql = "INSERT INTO reply(boardnum, userid, content) values(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rdto.getBoardnum());
			pstmt.setString(2, rdto.getUserid());
			pstmt.setString(3, rdto.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
		
	}

	public void deleteReply(int replyNum) {
		con = Dbm.getConnection();
		String sql = "DELETE FROM reply WHERE replynum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, replyNum);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
	}

	public int getReplyCount(int num) {
		int count = 0;
		con = Dbm.getConnection();
		String sql = "SELECT COUNT(*) AS cnt FROM reply WHERE boardnum=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) count=rs.getInt("cnt");
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
		return count;
	}

	public int getAllCount() {
		int count = 0;
		con = Dbm.getConnection();
		String sql = "SELECT COUNT(*) AS cnt FROM board";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) count=rs.getInt("cnt");
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dbm.close(con, pstmt, rs);
		}
		return count;
	}
	
}
