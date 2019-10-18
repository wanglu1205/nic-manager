package com.nic.dal.mapper;

import com.nic.dal.entity.Package;
import com.nic.dal.entity.PackageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PackageMapper {
    /**
     *
     * @mbggenerated 2019-10-18
     */
    int countByExample(PackageExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int deleteByExample(PackageExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int insert(Package record);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int insertSelective(Package record);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    List<Package> selectByExample(PackageExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    Package selectByPrimaryKey(Long id);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByExampleSelective(@Param("record") Package record, @Param("example") PackageExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByExample(@Param("record") Package record, @Param("example") PackageExample example);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByPrimaryKeySelective(Package record);

    /**
     *
     * @mbggenerated 2019-10-18
     */
    int updateByPrimaryKey(Package record);
}