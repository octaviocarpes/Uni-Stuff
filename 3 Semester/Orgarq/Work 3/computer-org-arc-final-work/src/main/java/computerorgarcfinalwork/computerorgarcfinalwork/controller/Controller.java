package computerorgarcfinalwork.computerorgarcfinalwork.controller;

import computerorgarcfinalwork.computerorgarcfinalwork.service.Service;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController()
public class Controller {

    private Service service;

    @GetMapping(value = "api/question/1/")
    public String answerOne(){
        return "Answer 1";
    }

    @GetMapping(value = "api/question/2/")
    public String answerTwo(){
        return "Answer 2";
    }

    @GetMapping(value = "api/question/3/")
    public String answerThree(){
        return "Answer 3";
    }

    @GetMapping(value = "api/question/4/")
    public String answerFour(){
        return "Answer 4";
    }
}
