package com.king.business.controller.admin;

import com.king.business.dto.ChapterDTO;
import com.king.business.dto.PageDTO;
import com.king.business.service.ChapterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    public static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);

    @Autowired
    private ChapterService chapterService;

    @PostMapping("/list")
    public PageDTO list(@RequestBody PageDTO pageDTO) {
        LOG.info("/admin/chapter/list，入参：PageDTO：{}", pageDTO.toString());
        chapterService.list(pageDTO);
        return pageDTO;
    }

    @PostMapping("/save")
    public ChapterDTO save(@RequestBody ChapterDTO chapterDTO) {
        LOG.info("/admin/chapter/save，入参：ChapterDTO：{}", chapterDTO.toString());
        chapterService.save(chapterDTO);
        return chapterDTO;
    }

}
