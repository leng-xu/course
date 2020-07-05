package com.king.business.controller.admin;

import com.king.business.dto.ChapterDTO;
import com.king.business.dto.PageDTO;
import com.king.business.service.ChapterService;
import com.king.server.dto.ResponseDTO;
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
    public ResponseDTO list(@RequestBody PageDTO pageDTO) {
        LOG.info("/admin/chapter/list，入参：PageDTO：{}", pageDTO.toString());
        ResponseDTO responseDTO = new ResponseDTO();
        chapterService.list(pageDTO);
        responseDTO.setContent(pageDTO);
        return responseDTO;
    }

    @PostMapping("/save")
    public ResponseDTO save(@RequestBody ChapterDTO chapterDTO) {
        LOG.info("/admin/chapter/save，入参：ChapterDTO：{}", chapterDTO.toString());
        ResponseDTO responseDTO = new ResponseDTO();
        chapterService.save(chapterDTO);
        responseDTO.setContent(chapterDTO);
        return responseDTO;
    }

}
