package org.example.condigbat.payload;

import org.example.condigbat.entity.Case;
import org.example.condigbat.entity.Problem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CaseDTO {
    private Long id;

    private String args;

    private String expected;

    private Boolean visible;

    private Integer problem;

    public static Case DTO(CaseDTO caseDTO, Problem problem){
        Case case1 =  new Case(caseDTO.getArgs(), caseDTO.getExpected(), caseDTO.getVisible(), problem);
        case1.setId(caseDTO.getId());
        return case1;
    }

    public static CaseDTO OTD(Case case1){
        return new CaseDTO(case1.getId(), case1.getArgs(),
                case1.getExpected(),case1.getVisible(),case1.getProblem().getId());
    }

    public static List<Case> ListDTOs(List<CaseDTO> caseDTOS, Problem problem){
        List<Case> cases = new ArrayList<>();
        for (CaseDTO caseDTO : caseDTOS)
            cases.add(DTO(caseDTO,problem));
        return cases;
    }

    public static List<CaseDTO> ListOTDs(List<Case> cases){
        List<CaseDTO> caseDTOS = new ArrayList<>();
        for (Case case1 : cases)
            caseDTOS.add(OTD(case1));
        return caseDTOS;
    }

}
