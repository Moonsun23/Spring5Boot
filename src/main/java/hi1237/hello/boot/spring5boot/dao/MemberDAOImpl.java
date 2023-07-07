package hi1237.hello.boot.spring5boot.dao;

import hi1237.hello.boot.spring5boot.model.Member;
import hi1237.hello.boot.spring5boot.model.Zipcode;
import hi1237.hello.boot.spring5boot.mybatis.MemberMapper;
import lombok.RequiredArgsConstructor;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@RequiredArgsConstructor

public class MemberDAOImpl implements MemberDAO{

    // mybatis를 사용하기 위해 필요한 객체 DI
    // 단, 생성자 주입방식 사용!
    @Autowired
    final MemberMapper memberMapper;
    final MemberMapper insertMapper;

    @Override
    public int insertMember(Member m) {

        // sqlSession.insert("insertMember", m)로 사용하는 방식보다는 편리
        //return sqlSession.insert("hi1237.hello.boot.spring5boot.mybatis.MemberMapper.insertMember", m);
        return memberMapper.insertMember(m);

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


}
