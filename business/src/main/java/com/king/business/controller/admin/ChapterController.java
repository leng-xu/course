package com.king.business.controller.admin;

import com.king.business.domain.Chapter;
import com.king.business.dto.ChapterDTO;
import com.king.business.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping("/chapterList")
    public List<ChapterDTO> list() {
        return chapterService.list();
    }

}
