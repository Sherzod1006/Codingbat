package org.example.condigbat.payload;

import lombok.Getter;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ViewDTO {

    private SearchingDTO searching = new SearchingDTO();

    private List<SortingDTO> sorting = new ArrayList<>();

    private FilterDTO filtering = new FilterDTO();
}
