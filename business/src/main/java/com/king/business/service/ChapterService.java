package com.king.business.service;

import com.king.business.dto.ChapterDTO;
import com.king.business.dto.PageDTO;

public interface ChapterService {

    void delete(String id);

    void save(ChapterDTO chapterDTO);

    void list(PageDTO pageDTO);

}
