package hi1237.hello.boot.spring5boot.board;


import hi1237.hello.boot.spring5boot.model.Board;
import hi1237.hello.boot.spring5boot.mybatis.BoardMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
        // 여기 내용이랑 아래 오류가 연관: 내가 쓰는 DB 시스템을 대입시켜라!

public class BoardMapperUnitTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    @DisplayName("boardMapper select Test")
    void selectBoard() {

        int cpg =1;
        int stnum = (cpg - 1) * 25;

       List<Board> results = boardMapper.selectBoard(stnum);
        System.out.println(results);
        assertNotNull(results);


    }

    @Test
    @DisplayName("boardMapper selectOne Test")
    void selectOneBoard() {

        String bno="1576";

        Board result = boardMapper.selectOneBoard(bno);
        //System.out.println(results);
        assertNotNull(result);


    }

    @Test
    @DisplayName("boardMapper insert Test")
    @Transactional
    void insertBoard() {
        Board b= new Board();
        b.setUserid("abc123");
        // 가입된 아이디만 글을 쓸 수 있어서 없는 아이디로 치면 테스트 실패 뜸
        b.setTitle("테스트");
        b.setContents("테스트");
        b.setIpaddr("127.0.0.1");


        int result = boardMapper.insertBoard(b);
        //System.out.println(results);
        assertEquals(result, 1);


    }
    @Test
    @DisplayName("boardMapper updateView Test")
    void updateViewBoard() {

        String bno="800";

        int result = boardMapper.updateViewBoard(bno);
        //System.out.println(results);
        assertEquals(result, 1);


    }

    @Test
    @DisplayName("boardMapper countPage Test")
    void countPage() {

        int result = boardMapper.selectCountBoard();
        //System.out.println(results);
        assertNotNull(result);


    }

    @Test
    @DisplayName("boardMapper findBoard Test")
    void findBoard() {

        Map<String, Object> params = new HashMap<>();
        params.put("findtype", "titcont");
        params.put("findkey", "비가");
        params.put("stnum", 0);

        List<Board> results = boardMapper.selectFindBoard(params);
        assertNotNull(results);
    }

    @Test
    @DisplayName("boardMapper countfindBoard Test")
    void countFindBoard() {

        Map<String, Object> params = new HashMap<>();
        params.put("findtype", "title");
        params.put("findkey", "비가와");

        int result = boardMapper.countFindBoard(params);
        assertNotNull(result);
    }
}
