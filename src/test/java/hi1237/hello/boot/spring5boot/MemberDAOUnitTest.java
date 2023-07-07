package hi1237.hello.boot.spring5boot;


import hi1237.hello.boot.spring5boot.model.Member;
import hi1237.hello.boot.spring5boot.dao.MemberDAO;
import hi1237.hello.boot.spring5boot.dao.MemberDAOImpl;
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
@Import(MemberDAOImpl.class)
// 아래 Autowired로 MemberDAO 내용을 데려와야하는데 못데려와서 위 import를 다시 해줌

public class MemberDAOUnitTest {

    @Autowired
    private MemberDAO memberDAOImpl;

    @Test
    @DisplayName("MemberDAO Test")   // 아래 void를 안쓰면 MemberDAO insert Test라고 써야...
    void insertMember() {

        Member m = new Member(null, "","","","","","","","", null);

        int result = memberDAOImpl.insertMember(m);
        System.out.println(result);
        assertEquals(result, 1);


    }

    @Test
    @DisplayName("MemberDAO select Test")
    void selectMember() {

        List<Member> results = memberDAOImpl.selectMember();
        System.out.println(results);
        assertNotNull(results);


    }
}
