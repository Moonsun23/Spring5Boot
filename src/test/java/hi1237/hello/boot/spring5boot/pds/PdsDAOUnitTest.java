package hi1237.hello.boot.spring5boot.pds;


import hi1237.hello.boot.spring5boot.dao.BoardDAO;
import hi1237.hello.boot.spring5boot.dao.BoardDAOImpl;
import hi1237.hello.boot.spring5boot.dao.PdsDAO;
import hi1237.hello.boot.spring5boot.dao.PdsDAOImpl;
import hi1237.hello.boot.spring5boot.model.Board;
import hi1237.hello.boot.spring5boot.model.Pds;
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
@Import(PdsDAOImpl.class)
// 아래 Autowired로 MemberDAO 내용을 데려와야하는데 못데려와서 위 import를 다시 해줌

public class PdsDAOUnitTest {

    @Autowired
    private PdsDAO pdao;

    @Test
    @DisplayName("PdsDAO select Test")
    void selectPds() {
        int cpg =1;
        int stnum = (cpg - 1) * 25;

        List<Pds> results = pdao.selectPds(stnum);

       // System.out.println(results);
        assertNotNull(results);


    }

    @Test
    @DisplayName("PdsDAO selectOne Test")
    void selectOnePds() {
        String pno = "12";

        Pds result = pdao.selectOnePds(pno);

        // System.out.println(results);
        assertNotNull(result);


    }




}
