package hi1237.hello.boot.spring5boot.mybatis;

import hi1237.hello.boot.spring5boot.model.Pds;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface PdsMapper {

    int insertPds(Pds b);

    int lastPdsPno();

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





}
