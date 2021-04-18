package kr.or.connect.guestbook.dao;

public class GuestbookDaoSqls {
	// 상수 static final, 상수 변수명은 대문자로 해주웁시이다
	// query 문의 변수 _소문자 -> :대문자로 전환
	public static final String SELECT_PAGING = "SELECT id, name, content, regdate FROM guestbook ORDER BY id DESC limit :start, :limit";
	// limit query 시작, desc limit -> id 값 제일 큰것부터 작은 순서로 :limit 갯수만큼 출력
	public static final String DELETE_BY_ID = "DELETE FROM guestbook WHERE id = :id";
	public static final String SELECT_COUNT = "SELECT count(*) FROM guestbook";

}