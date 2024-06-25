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

    // MyFramework 사용 시 객체 선언 (Connection/PreparedStatement/ResultSet 대신 활용)
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

    private final String NS = "com.min.app.dao.BoardMapper.";
    
  @Override
  public int getBoardCount() {
    SqlSession ss = factory.openSession();
    int count = ss.selectOne(NS + "getBoardCount"); // 메소드의 이름이 id 와 일치함
    ss.close();
    return count;
  }

  @Override
  public List<BoardDTO> getBoardList(Map<String, Object> params) {
    // params 에는 begin1, end 20, sort DESC 등의 값이 들어감
    SqlSession ss = factory.openSession();
    List<BoardDTO> boardList = ss.selectList(NS + "getBoardList", params);
    ss.close();
    return boardList;
  }

  @Override
  public BoardDTO getBoardByNo(int boardNo) {
    SqlSession ss = factory.openSession();
    BoardDTO board = ss.selectOne(NS + "getBoardByNo", boardNo); // 앞에꺼는 호출, 뒤는 보내기
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
