package org.example.condigbat.service;

import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.CompileDTO;
import org.example.condigbat.payload.UserProblemDTO;

import java.util.List;

public interface UserProblemService {

    ApiResult<UserProblemDTO> get(Integer userId, Integer problemId);

    ApiResult<CompileDTO> solveProblemByUser(Integer problemId, UserProblemDTO userProblemDTO);

    ApiResult<List<UserProblemDTO>> getAllProblems();
}
