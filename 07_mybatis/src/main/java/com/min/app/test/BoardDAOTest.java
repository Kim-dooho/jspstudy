package com.min.app.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.app.dao.BoardDAO;
import com.min.app.dao.BoardDAOImpl;
import com.min.app.dto.BoardDTO;

public class BoardDAOTest {

  private BoardDAO boardDAO = BoardDAOImpl.getInstance();
  
  @Test
  public void test1() {
    assertEquals(1000, boardDAO.getBoardCount()); // 1000 개를 기대한다.
  }
  
  @Test
  public void test2() {
    Map<String, Object> params = Map.of("begin", 1
                                      , "end", 20
                                      , "column", "create_dt"
                                      , "sort", "ASC");
    List<BoardDTO> boardList = boardDAO.getBoardList(params);
    boardList.stream().forEach(board -> System.out.println(board));
  }
  
  
  @Test
  public void test3() {  
    BoardDTO board = boardDAO.getBoardByNo(1);
    assertNotNull(board); // null 이 아니면 test 통과
    // assertEquals(1, board.getBoardNo());
  }

}
