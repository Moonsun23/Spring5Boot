package hi1237.hello.boot.spring5boot.dao;

import hi1237.hello.boot.spring5boot.model.Board;


import java.util.List;

public interface BoardDAO {
    int insertBoard(Board b);

    List<Board> selectBoard(int stnum);

    Board selectOneBoard(String bno);

    int selectCountBoard();
}
