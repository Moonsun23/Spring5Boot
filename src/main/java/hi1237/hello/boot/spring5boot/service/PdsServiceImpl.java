package hi1237.hello.boot.spring5boot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import hi1237.hello.boot.spring5boot.dao.PdsDAO;
import hi1237.hello.boot.spring5boot.model.Pds;
import hi1237.hello.boot.spring5boot.model.PdsAttach;
import hi1237.hello.boot.spring5boot.utils.PdsUtils;

import java.util.List;
import java.util.Map;

@Service("psrv")
@RequiredArgsConstructor
public class PdsServiceImpl implements PdsService {

    final PdsDAO pdao;
    final PdsUtils pdsUtils;

    @Override
    public int newPds(Pds p) {

        return pdao.insertPds(p);
    }

    @Override
    public boolean newPdsAttach(MultipartFile attach, int pno) {

        // 첨부한 파일을 지정한 위치에 저장후 파일정보 리턴
        PdsAttach pa = pdsUtils.processUpload(attach);
        pa.setPno(pno + "");

        // 첨부파일 정보를 디비에 저장
        int pacnt = pdao.insertPdsAttach(pa);

        return (pacnt > 0) ? true : false;
    }

    @Override
    public List<Pds> readPds(Integer cpg) {
        int stnum = (cpg -1) * 25;
        // 0부터 24번까지 가져오는 개념으로 이해.
        return pdao.selectPds(stnum);
    }

    @Override
    public int countPds() {
        return pdao.selectCountPds();
    }

    @Override
    public Pds readOnePds(String pno) {
        return pdao.selectOnePds(pno);
    }

}
