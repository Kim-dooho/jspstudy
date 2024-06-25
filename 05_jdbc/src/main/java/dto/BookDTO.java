package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/* DTO : Data Transfer Object (테이블 하나당 DTO 하나, VO와 유사함) */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookDTO { // 테이블에서 가져온 데이터를 저장하기 위한 기능, db 는 연결 이후 정보 전달 후 연결을 끊어야 함
  private int book_no;
  private String title;
  private String author;
  private int price;
}
