package hi1237.hello.boot.spring5boot.service;

import hi1237.hello.boot.spring5boot.model.Pds;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PdsService {

    int newPds(Pds p);
    // return타입 ....

    boolean newPdsAttach(MultipartFile attach, int pno);


}
