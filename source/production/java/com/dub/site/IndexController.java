package com.dub.site;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController
{
    @RequestMapping({"/", "backHome"})
    public String index()
    {
        return "heapsort/heapSort";
    }
}
