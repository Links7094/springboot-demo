package com.example.demo.service.impl;

import com.example.demo.entity.Company;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author links
 * @since 2018-10-27
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
