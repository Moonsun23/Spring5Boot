package hi1237.hello.boot.spring5boot.utils;

import hi1237.hello.boot.spring5boot.model.GalAttach;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Component
// 일반 클래스는 Component로 관리
// PdsServiceImpl의 pdsUtils 클래스..

public class GalleryUtils {

    Logger logger = LogManager.getLogger(GalleryUtils.class);

    // 첨부파일 저장위치
    @Value("${saveImgDir}") private String saveImgDir;
    // savedir (어플리케이션프로퍼티스에 쓴거 불러오기)

    public GalAttach processUpload(List<MultipartFile> attachs) {
        // 이미지 첨부파일명과 크기는 먼저 리스트에 저장한 뒤
        // 나중에 문자열로 취합해서 저장
        GalAttach ga = new GalAttach();

        List<String> fnames = new ArrayList<>();
        List<String> fsizes = new ArrayList<>();

        //첨부된 이미지 파일 '들' 에 대한 반복 처리
        for(MultipartFile attach : attachs) {


            // 업로드 할 파일 정보 알아내기 - 첨부파일명
           String fname= makeUUID() + attach.getOriginalFilename();

            // 업로드 할 파일 정보 알아내기 - 파일크기
            String fsize =attach.getSize() / 1024 + "";

            // 첨부파일을 지정한 위치에 저장
            String savepath = saveImgDir + fname;
            try {
                attach.transferTo(new File(savepath));

                // 첨부파일 정보를 리스트에 저장
                fnames.add(fname);
                fsizes.add(fsize);

            } catch (Exception e) {
                logger.error("첨부파일 처리 중 오류 발생!!!!!!!!!!!");
                e.printStackTrace();
            }

        } // 위 for문과 관련된 .. 파일 업로드 반복처리를 위해 써주는거임

        // 수집된 첨부파일 정보를 ga에 저장
        // join(구분자, 리스트) - 요소1;요소2;요소3- 개별 요소들을 세미콜론으로 구분해줌 ---- 파이썬할 때도 배움
        ga.setFname(String.join(";", fnames));      // fname에 저장
        ga.setFsize(String.join(";", fsizes));          // fsize 저장

        return ga;
    }

    private String makeUUID() {
        String uuid = LocalDate.now() + "" + LocalTime.now();
        uuid= uuid.replace("-", "")
                        .replace(":", "")
                        .replace(".", "");
        // 앞의 타겟을 찾아 대체해준다.
        return uuid;
    }

    public void makeThumbnail(GalAttach ga) {
        // 업로드 된 이미지들 중 첫번째 이미지에 대한 썸네일 생성
        // 파일이름들을 ;(세미콜론)으로 나눈 후 첫번째 파일명만 추출

        String basename = ga.getFname().split(";")[0];
        // 이름 가져오고, 첫번째 세미콜론에서 split 해라

        // 업로드 된 첫번째 이미지 파일 경로 설정
        String refname = saveImgDir + basename;

        // 썸네일 이미지 경로 설정
        // 원본이 abc123.jpg 라면
        // 썸네일은 small_abc123.jpg
        String thumbname = saveImgDir + "_thumbs/small_" + basename;

        // 썸네일 작업 진행

        try {
            // 원본이미지를 읽어서 메모리에 이미지객체(캔버스)를 생성
            BufferedImage img = ImageIO.read(new File(refname));
            //ref(원본이미지)를 읽어온다..

            // 이미지 크기와 crop 좌표 설정
            int imgW = Math.min(img.getHeight(), img.getWidth()) / 2;           // 최대 사이즈를 절반으로 나누고(이미지의 높이 넓이를 비교해서 나눔)
            int imgH = imgW;

            // 지정한 위치를 기준으로 잘라냄
            // crop(대상, x좌표, y좌표, 잘라낼너비, 잘라낼높이, 투명도)
            BufferedImage scaleImg = Scalr.crop(img,
                    (img.getWidth() - imgW) / 2,
                    (img.getHeight() - imgH) / 2,  // crop할 좌표
                    imgW, imgH,   // crop할 이미지 크기
                    null); // 투명도는 따로 지정하지 않음

            // 잘라낸 이미지를 330x350 크기로 재조정
            BufferedImage resizeImg = Scalr.resize(
                    scaleImg, 330, 350, null);

            // 재조정한 이미지를 실제 경로에 저장
            ImageIO.write(resizeImg, "png", new File(thumbname));

        } catch (Exception ex) {
            logger.error("이미지 썸네일 작업 중 오류 발생.................!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            ex.printStackTrace();
        }

    }
}
