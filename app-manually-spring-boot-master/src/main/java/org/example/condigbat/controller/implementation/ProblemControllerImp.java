package org.example.condigbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.example.condigbat.controller.cotract.ProblemController;
import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.ProblemDTO;
import org.example.condigbat.service.ProblemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProblemControllerImp implements ProblemController {

    private final ProblemService service;

    public ApiResult<List<ProblemDTO>> getAllBySectionId(Integer sectionId) {
        return service.getAllProblemsBySectionId(sectionId);
    }


    public ApiResult<ProblemDTO> getById(Integer id) {
        return service.getProblemById(id);
    }

    public ApiResult<ProblemDTO> add(ProblemDTO problemDTO) {
        return service.addProblem(problemDTO);
    }

    public ApiResult<ProblemDTO> update(Integer id, ProblemDTO problemDTO) {
        return service.updateProblemById(id, problemDTO);
    }

    public void deleteById(Integer id) {
        service.deleteById(id);
    }

    public void deleteAllBySectionId(Integer sectionId) {
        service.deleteAllBySectionId(sectionId);
    }
}
