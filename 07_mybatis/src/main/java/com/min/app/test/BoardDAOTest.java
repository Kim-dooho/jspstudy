package com.min.app.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.min.app.dao.BoardDAO;
import com.min.app.dao.BoardDAOImpl;
import com.min.app.dto.BoardDTO;

public class BoardDAOTest {

  private BoardDAO boardDAO = BoardDAOImpl.getInstance();
  
  @Test
  public void test() {  
    BoardDTO board = boardDAO.getBoardByNo(0);
    assertEquals(1, board.getBoardNo());
  }

}
