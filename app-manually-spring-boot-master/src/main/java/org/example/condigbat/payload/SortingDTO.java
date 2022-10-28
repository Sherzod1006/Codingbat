package org.example.condigbat.payload;

import lombok.Getter;
import org.example.condigbat.payload.enums.SortingTypeEnum;

@Getter
public class SortingDTO {

    private String name;

    private SortingTypeEnum type;
}
