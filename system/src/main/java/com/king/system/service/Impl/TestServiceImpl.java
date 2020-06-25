package com.king.system.service.Impl;

import com.king.system.domain.Test;
import com.king.system.mapper.TestMapper;
import com.king.system.service.TestService;
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
