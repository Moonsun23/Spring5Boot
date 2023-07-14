package hi1237.hello.boot.spring5boot.controller;

import hi1237.hello.boot.spring5boot.model.Pds;

import hi1237.hello.boot.spring5boot.service.PdsService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


//지시문을 써야한다.(아래 컨트롤러)
@Controller
@RequestMapping("/pds")
@RequiredArgsConstructor

public class PdsController {

    final PdsService psrv;

    Logger logger = LogManager.getLogger(PdsController.class);

    @GetMapping("/list")
    public String list(){
        logger.info("gallery/list 호출!");
        return "list-";
    }

    @GetMapping("/write")
    public String write(){
        logger.info("pds/write 호출!");

        return "pds/write";

    }

    @PostMapping("/write")
    public String writeok(Pds p, MultipartFile attach){
        logger.info("pds/writeok 호출!");
        String returnPage = "redirect:/pds/fail";


        // 작성한 게시글을 먼저 DB에 저장하고 글번호를 알아냄(알아내서 pinfo로 값 넘기기)
        int pno = psrv.newPds(p);

        // 알아낸 글 번호를 이용해서 첨부파일 처리(DB저장 과 업로드)
        if (!attach.isEmpty()) {     //첨부파일이 존재한다면
            psrv.newPdsAttach(attach, pno);
            returnPage = "redirect:/pds/list/1";
        }
        return returnPage;

    }

}
