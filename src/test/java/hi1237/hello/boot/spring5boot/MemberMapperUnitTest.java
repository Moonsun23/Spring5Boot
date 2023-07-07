package hi1237.hello.boot.spring5boot;


import hi1237.hello.boot.spring5boot.model.Member;
import hi1237.hello.boot.spring5boot.mybatis.MemberMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.assertEquals;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
        // 여기 내용이랑 아래 오류가 연관: 내가 쓰는 DB 시스템을 대입시켜라!

public class MemberMapperUnitTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    @DisplayName("MemberMapper Insert Test")
    void insertMember() {

        Member m = new Member(null, "","","","","","","","", null);

        int result = memberMapper.insertMember(m);
        System.out.println(result);
        assertEquals(result, 1);


    }
}
