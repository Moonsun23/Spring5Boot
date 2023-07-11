package hi1237.hello.boot.spring5boot.dao;

import hi1237.hello.boot.spring5boot.model.Member;
import hi1237.hello.boot.spring5boot.model.Zipcode;

import java.util.List;

public interface MemberDAO {
    int insertMember(Member m);

    List<Member> selectMember();

    List<Zipcode> selectzip(String dong);



    int selectOneUserid(String uid);

    Member selectOneMember(Member m);
    // interface를 추가..후 임플리 가서 메서드 추가
}
