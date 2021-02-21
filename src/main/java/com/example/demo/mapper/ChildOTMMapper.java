package com.example.demo.mapper;

import com.example.demo.dto.ChildOTMDTO;
import com.example.demo.entities.ChildOTM;

public class ChildOTMMapper {

    public static ChildOTMDTO toDto(ChildOTM entity) {
        ChildOTMDTO dto = new ChildOTMDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setExtra(entity.getExtra());
        dto.setExtraTwo(entity.getExtraTwo());

        return dto;
    }
}
