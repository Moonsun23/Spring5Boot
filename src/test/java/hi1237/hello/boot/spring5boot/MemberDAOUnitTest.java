package hi1237.hello.boot.spring5boot;


import hi1237.hello.boot.spring5boot.dao.Member;
import hi1237.hello.boot.spring5boot.dao.MemberDAO;
import hi1237.hello.boot.spring5boot.dao.MemberDAOImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
        // 여기 내용이랑 아래 오류가 연관: 내가 쓰는 DB 시스템을 대입시켜라!
@Import(MemberDAOImpl.class)
// 아래 Autowired로 MemberDAO 내용을 데려와야하는데 못데려와서 위 import를 다시 해줌

public class MemberDAOUnitTest {

    @Autowired
    private MemberDAO mdao;

    @Test
    @DisplayName("MemberDAO Test")   // 아래 void를 안쓰면 MemberDAO insert Test라고 써야...
    void insertMember() {

        Member m = new Member(null, "","","","","","","","", null);

        int result = mdao.insertMember(m);
        System.out.println(result);
        assertEquals(result, 1);


    }
}
