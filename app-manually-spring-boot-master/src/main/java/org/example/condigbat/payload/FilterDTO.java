package org.example.condigbat.payload;

import lombok.Getter;
import org.example.condigbat.payload.enums.OperatorTypeEnum;

import java.util.ArrayList;
import java.util.List;

@Getter
public class FilterDTO {

    private OperatorTypeEnum operatorType;//AND, OR

    private List<FilterColumnDTO> columns = new ArrayList<>();
}
