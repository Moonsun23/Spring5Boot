package hi1237.hello.boot.spring5boot.dao;

import hi1237.hello.boot.spring5boot.model.Member;
import hi1237.hello.boot.spring5boot.model.Zipcode;
import hi1237.hello.boot.spring5boot.mybatis.MemberMapper;
import lombok.RequiredArgsConstructor;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("mdao")
// 스프링 컨테이너에서 이 클래스를 빈으로 관리하기 위한 Repository 어노테이션입니다.
// "mdao"라는 이름으로 빈을 등록합니다.
@RequiredArgsConstructor

public class MemberDAOImpl implements MemberDAO{

    // mybatis를 사용하기 위해 필요한 객체 DI
    // 단, 생성자 주입방식 사용!
    final MemberMapper memberMapper;
    final MemberMapper insertMapper;

    @Override
    public int insertMember(Member m) {

        // sqlSession.insert("insertMember", m)로 사용하는 방식보다는 편리
        //return sqlSession.insert("hi1237.hello.boot.spring5boot.mybatis.MemberMapper.insertMember", m);
        return memberMapper.insertMember(m);
        // MemberMapper의 insertMember 메서드를 호출하여 Member 객체를 데이터베이스에 삽입합니다.
        // 삽입된 행의 개수를 반환합니다.
        // MemberMapper에서 데리고온 변수..
    }

    @Override
    public List<Member> selectMember() {
        return memberMapper.selectMember();
    }

    @Override
    public List<Zipcode> selectzip(String dong) {
        return memberMapper.findZipcode(dong);
    }

    @Override
    public int selectOneUserid(String uid) {
        return memberMapper.selectOneUserid(uid);
    }

    @Override
    public Member selectOneMember(Member m) {
        return memberMapper.selectOneMember(m);
    }


}

















