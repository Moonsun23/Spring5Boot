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

import java.util.List;

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


}
