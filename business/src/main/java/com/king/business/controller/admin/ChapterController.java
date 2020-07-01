package com.king.business.controller.admin;

import com.king.business.dto.ChapterDTO;
import com.king.business.dto.PageDTO;
import com.king.business.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @PostMapping("/list")
    public PageDTO list(@RequestBody PageDTO pageDTO) {
        chapterService.list(pageDTO);
        return pageDTO;
    }

}
