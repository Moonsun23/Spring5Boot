package hi1237.hello.boot.spring5boot;


import hi1237.hello.boot.spring5boot.dao.MemberDAO;
import hi1237.hello.boot.spring5boot.dao.MemberDAOImpl;
import hi1237.hello.boot.spring5boot.model.Member;
import hi1237.hello.boot.spring5boot.service.MemberService;
import hi1237.hello.boot.spring5boot.service.MemberServiceImpl;
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
@Import({MemberServiceImpl.class, MemberDAOImpl.class})
// 아래 Autowired로 MemberDAO 내용을 데려와야하는데 못데려와서 위 import를 다시 해줌

public class MemberServiceUnitTest {

    @Autowired
    private MemberService msrv;

    @Test
    @DisplayName("MemberService save Test")
    void saveMember() {

        Member m = new Member(null, "","","","","","","","","", null);

        boolean result = msrv.saveMember(m);
        System.out.println(result);
        assertEquals(result, true);


    }

    @Test
    @DisplayName("MemberService read Test")   // 아래 void를 안쓰면 MemberDAO insert Test라고 써야...
    void readMember() {

        List<Member> results = msrv.readMember();
        System.out.println(results);
        assertNotNull(results);


    }

    @Test
    @DisplayName("MemberService readOneMember Test")   // 아래 void를 안쓰면 MemberDAO insert Test라고 써야...
    void readOneMember() {
        Member m = new Member();
        m.setUserid("abc123");
        m.setPasswd("987xyz");

        Member result = msrv.readOneMember(m);
        System.out.println(result);
        assertNotNull(result);


    }
}
