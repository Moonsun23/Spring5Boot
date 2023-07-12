package hi1237.hello.boot.spring5boot.controller;

import hi1237.hello.boot.spring5boot.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor

public class BoardController {

    final BoardService bsrv;

    Logger logger = LogManager.getLogger(BoardController.class);

    @GetMapping("/list")
    public String list(Model m){
        logger.info("board/list 호출!");

        m.addAttribute("bds", bsrv.readBoard());
        //bsrv.readBoard를 실행해서 넘어온 결과가 bds로 넘어옴

        return "board/list";

    }



}
