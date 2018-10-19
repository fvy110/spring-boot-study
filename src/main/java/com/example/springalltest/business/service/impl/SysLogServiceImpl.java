package com.example.springalltest.business.service.impl;

import com.example.springalltest.business.bean.SysLog;
import com.example.springalltest.business.mapper.SysLogMapper;
import com.example.springalltest.business.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @ClassName SysLogServiceImpl
 * @Description TODO
 * @Author byp
 * @Date 2018/10/16 13:34
 * @Verison 0.0.1
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogMapper sysLogMapper;
    @Override
    public void insert(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }
}
