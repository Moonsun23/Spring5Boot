package hi1237.hello.boot.spring5boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//지시문을 써야한다.(아래 컨트롤러)
@Controller

public class IndexController {

    @GetMapping("/")
    public String index() {

        return "index";
    }
}
