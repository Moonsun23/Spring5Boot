package hi1237.hello.boot.spring5boot.service;

import hi1237.hello.boot.spring5boot.model.Board;

import java.util.List;

public interface BoardService {

    boolean saveBoard(Board b);
            // 데이터 추가하는거

    List<Board> readBoard(Integer cpg);

    Board readOneBoard(String bno);
}
