package hi1237.hello.boot.spring5boot.pds;


import hi1237.hello.boot.spring5boot.model.Board;
import hi1237.hello.boot.spring5boot.model.Pds;
import hi1237.hello.boot.spring5boot.model.PdsAttach;
import hi1237.hello.boot.spring5boot.mybatis.PdsMapper;
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

public class PdsMapperUnitTest {

    @Autowired
    private PdsMapper pdsMapper;

    @Test
    @DisplayName("PdsMapper lastid Test")
    @Transactional
    void lastIdPds() {
        Pds p= new Pds();
        p.setUserid("abc123");
        // 가입된 아이디만 글을 쓸 수 있어서 없는 아이디로 치면 테스트 실패 뜸
        p.setTitle("테스트");
        p.setContents("테스트");
        p.setIpaddr("127.0.0.1");

        pdsMapper.insertPds(p);

        int result = pdsMapper.lastPdsPno();
        //System.out.println(results);
        assertNotNull(result);


    }

    @Test
    @DisplayName("PdsMapper selectOnePA Test")

    void selectOnePA() {

        String pno = "23";

        PdsAttach result = pdsMapper.selectOnePdsAttach(pno);

        assertNotNull(result);


    }

}
