package com.king.server.service.Impl;


import com.king.server.domain.Test;
import com.king.server.mapper.TestMapper;
import com.king.server.service.TestService;
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
