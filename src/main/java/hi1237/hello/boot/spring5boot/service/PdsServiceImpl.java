package hi1237.hello.boot.spring5boot.service;

import hi1237.hello.boot.spring5boot.dao.PdsDAO;
import hi1237.hello.boot.spring5boot.model.Pds;
import hi1237.hello.boot.spring5boot.model.PdsAttach;
import hi1237.hello.boot.spring5boot.utils.PdsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service("psrv")
@RequiredArgsConstructor
public class PdsServiceImpl implements PdsService{
    final PdsDAO pdao;
    final PdsUtils pdsUtils;
    @Override
    public int newPds(Pds p) {
        return pdao.insertPds(p);
    }

    @Override
    public boolean newPdsAttach(MultipartFile attach, int pno) {

        // 첨부한 파일을 지정한 위치에 저장 후 파일정보 리턴(pa)
        PdsAttach pa = pdsUtils.processUpload(attach);
        pa.setPno(pno + ""); // 문자를 숫자로 쓰려면????


        // 첨부파일 정보를 디비에 저장
        int pacnt = pdao.insertPdsAttach(pa);

        return (pacnt > 0) ? true : false;
    }
}
