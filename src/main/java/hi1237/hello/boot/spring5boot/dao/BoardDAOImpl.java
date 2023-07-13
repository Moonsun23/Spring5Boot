package hi1237.hello.boot.spring5boot.dao;

import hi1237.hello.boot.spring5boot.model.Board;
import hi1237.hello.boot.spring5boot.mybatis.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("bdao")
@RequiredArgsConstructor

public class BoardDAOImpl implements BoardDAO{

    // @Autowired 없이 DI 구현
    final BoardMapper boardMapper;


    @Override
    public int insertBoard(Board b) {

        return boardMapper.insertBoard(b);
    }

    @Override
    public List<Board> selectBoard(int stnum) {

        return boardMapper.selectBoard(stnum);
    }

    @Override
    public Board selectOneBoard(String bno) {

        boardMapper.updateViewBoard(bno);

        return boardMapper.selectOneBoard(bno);
    }

    @Override
    public int selectCountBoard() {

        return boardMapper.selectCountBoard();
    }

    @Override
    public List<Board> selectFindBoard(Map<String, Object> params) {
        return boardMapper.selectFindBoard(params);
    }


}

















