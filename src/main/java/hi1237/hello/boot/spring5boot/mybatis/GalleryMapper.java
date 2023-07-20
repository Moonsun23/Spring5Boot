package hi1237.hello.boot.spring5boot.mybatis;

import hi1237.hello.boot.spring5boot.model.GalAttach;
import hi1237.hello.boot.spring5boot.model.Gallery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalleryMapper {
    int insertGallery(Gallery g);

    int insertGalAttach(GalAttach ga);
    // 사진이 여러개 넘어와양 해서 list로 써줌

    List<Gallery> selectGallery(int stnum);

    Gallery selectOneGallery(String gno);

    int selectCountGallery();

    GalAttach selectOneGalAttach(String gno);

//    int insertPdsComment(PdsComment pc);
//
//    List<PdsComment> selectPdsComment(String pno);
//
//    int insertPdsReply(PdsComment pc);

//    int updateViewPds(String bno);
//
//    List<Pds> selectFindPds(Map<String, Object> params);
//
//    int countFindPds(Map<String, Object> params);
}








