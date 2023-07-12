package hi1237.hello.boot.spring5boot.mybatis;

import hi1237.hello.boot.spring5boot.model.Member;
import hi1237.hello.boot.spring5boot.model.Zipcode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
// @Mapper 어노테이션은 MyBatis의 매퍼 인터페이스임을 나타냅니다.
// 이 인터페이스는 MyBatis와 연결되어 SQL 쿼리를 실행하는 메서드를 정의합니다.
public interface MemberMapper {

    int insertMember(Member m);
    // Member 객체를 데이터베이스에 삽입하는 메서드입니다.
    // 삽입된 행의 개수를 반환합니다.
    List<Member> selectMember();
    // 모든 회원 정보를 조회하는 메서드입니다.
    // Member 객체의 리스트를 반환합니다.

    List<Zipcode> findZipcode(String dong);
    // 동 이름으로 우편번호를 조회하는 메서드입니다.
    // 동 이름을 전달하고, 해당하는 우편번호 정보인 Zipcode 객체의 리스트를 반환합니다.

    int selectOneUserid(String uid);
    // 주어진 사용자 아이디(uid)가 이미 존재하는지 확인하는 메서드입니다.
    // 존재한다면 1을 반환하고, 존재하지 않는다면 0을 반환합니다.

    Member selectOneMember(Member m);
    // 주어진 Member 객체의 정보와 일치하는 회원 정보를 조회하는 메서드입니다.
    // 일치하는 회원 정보를 Member 객체로 반환합니다.
}
