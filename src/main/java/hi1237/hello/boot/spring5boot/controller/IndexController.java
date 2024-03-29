package hi1237.hello.boot.spring5boot.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



//지시문을 써야한다.(아래 컨트롤러)
@Controller

public class IndexController {


    Logger logger = LogManager.getLogger(IndexController.class);

    @GetMapping("/")
    public String index(){
        logger.info("index호출!");
        return "index";
    }
    @GetMapping("/intro")
    public String intro() {
        logger.info("intro 호출!");
        return "intro";
    }
    @GetMapping("/admin")
    public String admin() {
        logger.info("admin 호출!");
        return "admin";
    }
}
