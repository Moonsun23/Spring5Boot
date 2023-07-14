package hi1237.hello.boot.spring5boot.service;

import hi1237.hello.boot.spring5boot.model.Board;

import java.util.List;
import java.util.Map;

public interface BoardService {

    boolean saveBoard(Board b);
            // 데이터 추가하는거

    List<Board> readBoard(Integer cpg);

    Board readOneBoard(String bno);

    int countBoard();

    List<Board> readFindBoard(Integer cpg, String ftype, String fkey);

    int countFindBoard(String ftype, String fkey);
    // 검색하는데 필요한 값을 남겨준다



}
