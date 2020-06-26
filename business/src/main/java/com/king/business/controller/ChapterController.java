package com.king.business.controller;

import com.king.business.domain.Chapter;
import com.king.business.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping("/list")
    public List<Chapter> list() {
        return chapterService.list();
    }

}
