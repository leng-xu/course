package com.king.business.service.Impl;

import com.king.business.domain.Chapter;
import com.king.business.mapper.ChapterMapper;
import com.king.business.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public List<Chapter> list() {
        return chapterMapper.list();
    }

}
