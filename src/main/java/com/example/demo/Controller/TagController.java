package com.example.demo.Controller;

import com.example.demo.Common.ResultJson;
import com.example.demo.Service.TagService;
import com.example.demo.Service.imp.TagServiceImpl;
import com.example.demo.entity.mysql.ArticleTag;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class TagController {
    @Resource
    TagServiceImpl tagService;
    @GetMapping("/Tag/select")
    @ResponseBody
    public ResultJson selectTag(@RequestBody ArticleTag tag) {
        return tagService.selectTag(tag);
    }
}
