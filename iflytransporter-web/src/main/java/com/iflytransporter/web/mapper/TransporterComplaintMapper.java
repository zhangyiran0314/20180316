package com.iflytransporter.web.mapper;

import com.iflytransporter.common.bean.TransporterComplaint;

public interface TransporterComplaintMapper {
    int deleteByPrimaryKey(String id);

    int insert(TransporterComplaint record);

    int insertSelective(TransporterComplaint record);

    TransporterComplaint selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TransporterComplaint record);

    int updateByPrimaryKey(TransporterComplaint record);
}