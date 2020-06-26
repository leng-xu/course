package com.king.business.service.Impl;

import com.king.business.domain.Chapter;
import com.king.business.dto.ChapterDTO;
import com.king.business.mapper.ChapterMapper;
import com.king.business.service.ChapterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public List<ChapterDTO> list() {
        List<Chapter> chapterList = chapterMapper.list();
        List<ChapterDTO> chapterDTOList = new ArrayList<>();
        for (int i = 0; i < chapterList.size(); i++) {
            Chapter chapter = chapterList.get(i);
            ChapterDTO chapterDTO = new ChapterDTO();
            BeanUtils.copyProperties(chapter, chapterDTO);
            chapterDTOList.add(chapterDTO);
        }
        return chapterDTOList;
    }

}
