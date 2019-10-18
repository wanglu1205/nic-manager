package com.nic.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nic.common.model.PageResult;
import com.nic.common.model.dto.PackageListDto;
import com.nic.common.model.dto.PackageSaveDto;
import com.nic.common.model.vo.CustomerListVo;
import com.nic.common.model.vo.PackageListVo;
import com.nic.dal.entity.Customer;
import com.nic.dal.entity.Package;
import com.nic.dal.entity.PackageExample;
import com.nic.dal.mapper.PackageMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @auther: wl
 * @date: 2019/10/17
 * @description:
 * @since : 1.0
 */
@Service
public class PackageService {

    @Resource
    private PackageMapper packageMapper;

    @Resource
    private CustomerService customerService;


    public PageResult<PackageListVo> list(PackageListDto dto) {
        Page<PackageListVo> page = PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        PackageExample packageExample = new PackageExample();
        PackageExample.Criteria criteria = packageExample.createCriteria();
        if (StringUtils.isNotBlank(dto.getName())){
            criteria.andNameLike("%" + dto.getName() + "%");
        }
        List<Package> packages = packageMapper.selectByExample(packageExample);

        List<PackageListVo> vos = new ArrayList<>();
        packages.forEach(p -> {
            PackageListVo vo = new PackageListVo();
            vo.setId(p.getId());
            vo.setName(p.getName());
            vo.setPrice(p.getPrice());
            vo.setStandard(p.getStandard());
            vos.add(vo);
        });
        return new PageResult<>(page.getPageNum(), page.getPageSize(), page.getTotal(), vos);
    }

    public Package info(Long id) {
        return packageMapper.selectByPrimaryKey(id);
    }


    public Boolean save(PackageSaveDto dto) {
        if (Objects.isNull(dto.getId())){
            Package p = new Package();
            p.setName(dto.getName());
            p.setPrice(dto.getPrice());
            p.setStandard(dto.getStandard());
            Date date = new Date();
            p.setGmtCreate(date);
            p.setGmtModified(date);
            packageMapper.insertSelective(p);
        }else {
            Package p = new Package();
            p.setId(dto.getId());
            p.setName(dto.getName());
            p.setPrice(dto.getPrice());
            p.setStandard(dto.getStandard());
            Date date = new Date();
            p.setGmtModified(date);
            packageMapper.updateByPrimaryKeySelective(p);
        }
        return true;
    }
}
