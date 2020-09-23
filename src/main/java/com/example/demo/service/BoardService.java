package com.example.demo.service;

import com.example.demo.entity.Board;

import java.util.List;

//interface사용 이유 : 다형성
// A도 테스트[test()]하는 게 있고 B, C도 테스트하는게 있을 때,
// 각각의 이름을 통일하면서 사용방식은 다르게 사용.(데이터 처리의 일관성 제공 가능)

public interface BoardService {
    // DB를 처리할 때 오류가 발생할 수 있으므로
    // 예외 처리 루틴에게 해당 부분의 처리를 위임....
    public void register(Board board) throws Exception;
    public List<Board> list() throws Exception;
    public Board read(Integer boardNo) throws Exception;
    public void remove(Integer boardNo) throws Exception;
    public void modify(Board board) throws Exception;
}
