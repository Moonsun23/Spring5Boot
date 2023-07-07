package hi1237.hello.boot.spring5boot.dao;

import java.util.List;

public interface MemberDAO {
    int insertMember(Member m);

    List<Member> selectMember();

}
