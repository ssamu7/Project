package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// BoardService가 인터페이스!!!!
// 클래스 implements 인터페이스
//@Service(서비스 어노테이션)
// Spring이라는게 전부 Event Driven방식으로 동작을 하고 있음
public class BoardServiceImpl implements BoardService {
    // 클래스 사용할때 ? 객체가 필요하하다.
    // new를 해야한다는 의미
    // Autowired가 붙으면 이것을 자동으로 해줌
    @Autowired
    private BoardRepository boardRepository;

    @Override
    public void register(Board board) throws Exception {
        boardRepository.create(board);

    }

    @Override
    public List<Board> list() throws Exception {
        return boardRepository.list();
    }

    @Override
    public Board read(Integer boardNo) throws Exception {
        return boardRepository.read(boardNo);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        boardRepository.remove(boardNo);

    }

    @Override
    public void modify(Board board) throws Exception {
        boardRepository.modify(board);

    }
}
