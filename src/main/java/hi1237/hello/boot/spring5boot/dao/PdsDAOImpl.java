package hi1237.hello.boot.spring5boot.dao;

import hi1237.hello.boot.spring5boot.model.Pds;
import hi1237.hello.boot.spring5boot.mybatis.PdsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("pdao")

public class PdsDAOImpl implements PdsDAO{

    @Autowired
    private PdsMapper pdsMapper;


    @Override
    public int insertPds(Pds p) {
        int cnt = pdsMapper.insertPds(p);
        // insert 하고
        if (cnt > 0)
            cnt = pdsMapper.lastPdsPno();
        // insert 된 값을 가져온다고 생각

        return cnt;
    }
















}
