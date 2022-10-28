package org.example.condigbat.payload;

import lombok.Getter;
import org.example.condigbat.payload.enums.ConditionTypeEnum;

@Getter
public class FilterColumnDTO {

    private String name;

    private ConditionTypeEnum conditionType;

    private String value;

    private String from;

    private String till;
}
