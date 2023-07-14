package hi1237.hello.boot.spring5boot.board;


import hi1237.hello.boot.spring5boot.dao.BoardDAOImpl;
import hi1237.hello.boot.spring5boot.model.Board;
import hi1237.hello.boot.spring5boot.service.BoardService;
import hi1237.hello.boot.spring5boot.service.BoardServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
        // 여기 내용이랑 아래 오류가 연관: 내가 쓰는 DB 시스템을 대입시켜라!
@Import({BoardServiceImpl.class, BoardDAOImpl.class})
// 아래 Autowired로 MemberDAO 내용을 데려와야하는데 못데려와서 위 import를 다시 해줌

public class BoardServiceUnitTest {

    @Autowired
    private BoardService bsrv;



    @Test
    @DisplayName("BoardService read Test")
    void readBoard() {

        int cpg=1;

        List<Board> results = bsrv.readBoard(cpg);
        //System.out.println(results);
        assertNotNull(results);


    }

    @Test
    @DisplayName("BoardService readOne Test")
    void readOneBoard() {
        String bno= "1233";
        Board result = bsrv.readOneBoard(bno);
        //System.out.println(results);
        assertNotNull(result);


    }

    @Test
    @DisplayName("boardService save Test")
    @Transactional
    void saveBoard() {
        Board b= new Board();
        b.setUserid("abc123");
        // 가입된 아이디만 글을 쓸 수 있어서 없는 아이디로 치면 테스트 실패 뜸
        b.setTitle("테스트");
        b.setContents("테스트");
        b.setIpaddr("127.0.0.1");


        boolean result = bsrv.saveBoard(b);
        //System.out.println(results);
        assertEquals(result, true);


    }

    @Test
    @DisplayName("boardService countPage  Test")
    void countPage() {

        int result = bsrv.countBoard();
        //System.out.println(results);
        assertNotNull(result);


    }

    @Test
    @DisplayName("boardService findBoard Test")
    void findBoard() {

        int cpg = 1;
        String ftype = "title";
        String fkey = "비가와";

        List<Board> results = bsrv.readFindBoard(cpg, ftype, fkey);
        assertNotNull(results);
    }

    @Test
    @DisplayName("boardService countFindBoard Test")
    void countFindBoard() {

        String ftype = "title";
        String fkey = "비가와";

        int result = bsrv.countFindBoard(ftype, fkey);
        assertNotNull(result);
    }

}
