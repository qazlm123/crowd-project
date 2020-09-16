package com.atguigu.crowd.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PortalTypeVO {

    private Integer id;
    private String name;
    // 简短的介绍
    private String remark;

    private List<PortalProjectVO> PortalProjectVOList;

}
