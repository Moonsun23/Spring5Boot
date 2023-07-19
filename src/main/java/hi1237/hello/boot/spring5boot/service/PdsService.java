package hi1237.hello.boot.spring5boot.service;

import hi1237.hello.boot.spring5boot.model.PdsComment;
import org.springframework.web.multipart.MultipartFile;
import hi1237.hello.boot.spring5boot.model.Pds;

import java.util.List;
import java.util.Map;

public interface PdsService {

    int newPds(Pds p);

    boolean newPdsAttach(MultipartFile attach, int pno);

    List<Pds> readPds(Integer cpg);

    int countPds();

    Pds readOnePds(String pno);

    String readOnePdsAttach(String pno);

    Map<String, Object> getHeaderResource(String fname);


    // 아래 두개는 댓글관련 메서드
    boolean newPdsComment(PdsComment pc);

    List<PdsComment> readPdsComment(String pno);

    boolean newPdsReply(PdsComment pc);
}







