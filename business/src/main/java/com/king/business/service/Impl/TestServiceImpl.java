package com.king.business.service.Impl;

import com.king.business.domain.Test;
import com.king.business.mapper.TestMapper;
import com.king.business.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> list() {
        return testMapper.list();
    }

}
