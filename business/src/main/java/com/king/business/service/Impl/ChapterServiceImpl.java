package com.king.business.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.king.business.domain.Chapter;
import com.king.business.dto.ChapterDTO;
import com.king.business.dto.PageDTO;
import com.king.business.mapper.ChapterMapper;
import com.king.business.service.ChapterService;
import com.king.server.util.CopyUtil;
import com.king.server.util.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public void save(ChapterDTO chapterDTO) {
        Chapter chapter = CopyUtil.copy(chapterDTO, Chapter.class);
        if (StringUtils.isEmpty(chapterDTO.getId())) {
            this.insert(chapter);
        } else {
            this.update(chapter);
        }
    }

    private void update(Chapter chapter) {
        chapterMapper.updateByPrimaryKey(chapter);
    }

    private void insert(Chapter chapter) {
        chapter.setId(UUIDUtil.getShortUUID());
        chapterMapper.insert(chapter);
    }

    @Override
    public void list(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getSize());
        List<Chapter> chapterList = chapterMapper.selectByExample(null);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        pageDTO.setTotal((int) pageInfo.getTotal());
        List<ChapterDTO> chapterDTOList = new ArrayList<>();
        for (int i = 0; i < chapterList.size(); i++) {
            Chapter chapter = chapterList.get(i);
            ChapterDTO chapterDTO = new ChapterDTO();
            BeanUtils.copyProperties(chapter, chapterDTO);
            chapterDTOList.add(chapterDTO);
        }
        pageDTO.setList(chapterDTOList);
    }

}
