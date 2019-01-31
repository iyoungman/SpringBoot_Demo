package com.youngman.thymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by youngman on 2019-01-28.
 */
@Controller
public class SampleController {

    @GetMapping("/sample1")
    public void sampleTemplates(Model model) {
        model.addAttribute("greeting", "안녕하세요");
    }

    @GetMapping("/sample2")
    public void sampleTemplates2(Model model) {
        model.addAttribute("greeting2", "반갑습니다.");
    }

}
