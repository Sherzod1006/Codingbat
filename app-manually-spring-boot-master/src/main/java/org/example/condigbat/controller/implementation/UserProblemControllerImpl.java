package org.example.condigbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.example.condigbat.controller.cotract.UserProblemController;
import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.CompileDTO;
import org.example.condigbat.payload.UserProblemDTO;
import org.example.condigbat.service.UserProblemService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserProblemControllerImpl implements UserProblemController {

    private final UserProblemService userProblemService;

    @Override
    public ApiResult<UserProblemDTO> getUserProblem(Integer userId, Integer problemId) {
        return userProblemService.get(userId, problemId);
    }

    @Override
    public ApiResult<CompileDTO> solveProblem(Integer problemId, UserProblemDTO userProblemDTO) {
        return userProblemService.solveProblemByUser(problemId, userProblemDTO);
    }

    @Override
    public ApiResult<List<UserProblemDTO>> getUserProblems() {
        return userProblemService.getAllProblems();
    }

}
