package hi1237.hello.boot.spring5boot.utils;

import hi1237.hello.boot.spring5boot.model.PdsAttach;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;

@Component
// 일반 클래스는 Component로 관리
// PdsServiceImpl의 pdsUtils 클래스..

public class PdsUtils {

    Logger logger = LogManager.getLogger(PdsUtils.class);

    // 첨부파일 저장위치
    @Value("${saveDir}") private String saveDir;
    // savedir (어플리케이션프로퍼티스에 쓴거 불러오기)

    public PdsAttach processUpload(MultipartFile attach) {

        PdsAttach pa = new PdsAttach();

        // 업로드 할 파일 정보 알아내기 - 첨부파일명
        pa.setFname(makeUUID() + attach.getOriginalFilename());

        // 업로드 할 파일 정보 알아내기 - 확장자 추출
        // 파일명: abc123.zip -> 확장자: zip
        // 파일명.split(.)[1] - .을 기준으로 잘라서 첫번째
        // 파일명: abc123.987xyz.zip -> 확장자: zip
        // 파일명.substring(lastIndexOf(".")+1)

        int pos =  pa.getFname().lastIndexOf(".") + 1;
        pa.setFtype( pa.getFname().substring(pos) );

        // 업로드 할 파일 정보 알아내기 - 파일크기
        pa.setFsize( attach.getSize()/1024 + "" );

        // 첨부파일을 지정한 위치에 저장
        String savepath = saveDir + pa.getFname();
        try {
            attach.transferTo(new File(savepath));
        } catch (Exception e) {
            logger.error("첨부파일 처리 중 오류 발생!!!!!!!!!!!");
            e.printStackTrace();
        }

        return pa;
    }

    private String makeUUID() {
        String uuid = LocalDate.now() + "" + LocalTime.now();
        uuid= uuid.replace("-", "")
                        .replace(":", "")
                        .replace(".", "");
        // 앞의 타겟을 찾아 대체해준다.
        return uuid;
    }

    public HttpHeaders getHeader(String fname) {
        HttpHeaders header = new HttpHeaders();
        // 다운로드 할 파일의 이름을 인코딩 함 - 한글처리
        fname = UriUtils.encode(fname, StandardCharsets.UTF_8);

        try {
            // 다운로드 할  파일의 유형을 헤더에 저장
            header.add("Content-Type",
                    Files.probeContentType(Paths.get(saveDir + fname)));
            // 다운로드 시 표시할 파일이름 지정
            header.add("Content-Disposition", "attachment; filename=" + fname);
        } catch(Exception ex){
             ex.printStackTrace();
        }

        return header;
    }

    public UrlResource getResource(String fname) {
        UrlResource resource = null;

        fname = UriUtils.encode(fname, StandardCharsets.UTF_8);

        try{
            resource = new UrlResource("file:" + saveDir + fname);

        }catch(Exception ex){
            ex.printStackTrace();
        }

        return resource;


    }
}
