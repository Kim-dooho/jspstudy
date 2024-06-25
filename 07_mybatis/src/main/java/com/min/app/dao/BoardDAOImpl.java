package com.min.app.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.min.app.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {

    // MyFramework 사용 시 객체 선언(connection/preparedStatement
    private SqlSessionFactory factory;
    
    // Singleton Pattern
    private BoardDAOImpl() {
      // SqlSessionFactory factory build
      try {
        String resource = "com/min/app/config/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        factory = new SqlSessionFactoryBuilder().build(inputStream);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    private static BoardDAO boardDAO = new BoardDAOImpl();
    public static BoardDAO getInstance() {
      return boardDAO;
    }

  
  @Override
  public int getBoardCount() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<BoardDTO> getBoardList(Map<String, Object> params) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BoardDTO getBoardByNo(int boardNo) {
    SqlSession ss = factory.openSession();
    BoardDTO board = ss.selectOne("com.min.app.dao.BoardMapper.");
    ss.close();
    return board;
  }

  @Override
  public int insertBoard(BoardDTO board) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int deleteBoard(int board) {
    // TODO Auto-generated method stub
    return 0;
  }

}
