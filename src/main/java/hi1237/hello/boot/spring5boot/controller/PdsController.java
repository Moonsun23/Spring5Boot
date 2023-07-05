package hi1237.hello.boot.spring5boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//지시문을 써야한다.(아래 컨트롤러)
@Controller
@RequestMapping("/pds")

public class PdsController {


    Logger logger = LogManager.getLogger(PdsController.class);

    @GetMapping("/list")
    public String list(){
        logger.info("gallery/list 호출!");
        return "pds/list";
    }

}
