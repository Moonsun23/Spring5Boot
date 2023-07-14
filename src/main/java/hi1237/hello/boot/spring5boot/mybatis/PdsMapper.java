package hi1237.hello.boot.spring5boot.mybatis;

import hi1237.hello.boot.spring5boot.model.Pds;

import hi1237.hello.boot.spring5boot.model.PdsAttach;
import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface PdsMapper {

    int insertPds(Pds b);
    // 자료실 저장

    int lastPdsPno();

    int insertPdsAttach(PdsAttach pa);

}

    // 자료실의 첨부파일 저장

//    List<Pds> selectpds(int stnum);
//
//    Pds selectOnePds(String bno);
//
//    int updateViewPds(String bno);
//
//    int selectCountPds();
//
//    List<Pds> selectFindPds(Map<String, Object> params);
//
//    int countFindpds(Map<String, Object> params);
//    pdsMapper에서 추가하고 여기로 넘어옴






