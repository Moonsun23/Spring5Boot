package hi1237.hello.boot.spring5boot.service;

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
}







