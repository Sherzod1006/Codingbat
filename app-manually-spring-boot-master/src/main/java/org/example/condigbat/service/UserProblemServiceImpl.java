package org.example.condigbat.service;

import lombok.RequiredArgsConstructor;
import org.example.condigbat.compile.CompileResult;
import org.example.condigbat.compile.Compiler;
import org.example.condigbat.entity.Case;
import org.example.condigbat.entity.Problem;
import org.example.condigbat.entity.User;
import org.example.condigbat.entity.UserProblem;
import org.example.condigbat.exceptions.RestException;
import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.CompileDTO;
import org.example.condigbat.payload.UserProblemDTO;
import org.example.condigbat.repository.CaseRepository;
import org.example.condigbat.repository.ProblemRepository;
import org.example.condigbat.repository.UserProblemRepository;
import org.example.condigbat.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProblemServiceImpl implements UserProblemService {

    private final UserProblemRepository userProblemRepository;

    private final ProblemRepository problemRepository;

    private final UserRepository userRepository;

    private final CaseRepository caseRepository;



    @Override
    public ApiResult<UserProblemDTO> get(Integer userId, Integer problemId) {

        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty())
            throw RestException.restThrow("User Not Found!!!!!", HttpStatus.NOT_FOUND);


        Optional<Problem> problemOp = problemRepository.findById(problemId);
        if (problemOp.isEmpty())
            throw RestException.restThrow("Problem Not Found", HttpStatus.NOT_FOUND);


        Optional<UserProblem> userProblemOp =
                userProblemRepository.getUserProblemByProblemIdAndUserId(userId, problemId);

        UserProblemDTO userProblemDTO;
        if (userProblemOp.isEmpty()) {
            userProblemDTO = new UserProblemDTO(userId, problemOp.get(),
                    problemOp.get().getMethodSignature(), null);
        } else {
            userProblemDTO = new UserProblemDTO(userId, problemOp.get(),
                    userProblemOp.get().getSolution(), userProblemOp.get().getSolved());
        }
        return ApiResult.successResponse(userProblemDTO);
    }


    @Override
    public ApiResult<CompileDTO> solveProblemByUser(Integer problemId, UserProblemDTO userProblemDTO) {

        Optional<Problem> problemOp = problemRepository.findById(problemId);
        if (problemOp.isEmpty())
            throw RestException.restThrow("Problem Not Found", HttpStatus.NOT_FOUND);


        Optional<User> user = userRepository.findById(userProblemDTO.getUserId());
        if (user.isEmpty())
            throw RestException.restThrow("User Not Found!!!!!", HttpStatus.NOT_FOUND);


        List<Case> allByProblemId = caseRepository.getAllByProblemId(problemId);

        userProblemDTO.setProblem(problemOp.get());
        boolean isPrime = true;
        String errorMessage = null;
        List<CompileResult> compileResults = new ArrayList<>();

        try {
            compileResults = Compiler.staticCompiler(userProblemDTO, allByProblemId);
        } catch (RuntimeException e) {
            errorMessage = e.getMessage();
            isPrime = false;
        }


        boolean isSuccess = checkTrue(compileResults);

        if (!isPrime) {
            addUserProblem(userProblemDTO, false);
            return ApiResult.successResponse(new CompileDTO(userProblemDTO, errorMessage));
        }
        addUserProblem(userProblemDTO, isSuccess);
        userProblemDTO.setSolved(isSuccess);

        return ApiResult.successResponse(new CompileDTO(userProblemDTO, compileResults));
    }

    @Override
    public ApiResult<List<UserProblemDTO>> getAllProblems() {

        List<UserProblem> userProblemList = userProblemRepository.findAll();

        List<UserProblemDTO> userProblemDTOList = mapUserProblemsToUserProblemDTO(userProblemList);

        return ApiResult.successResponse(userProblemDTOList);
    }

    private List<UserProblemDTO> mapUserProblemsToUserProblemDTO(List<UserProblem> userProblemList) {

        List<UserProblemDTO> userProblemDTOList = new ArrayList<>();

        for (UserProblem userProblem : userProblemList) {
            UserProblemDTO userProblemDTO = mapUserProblemToUserProblemDTO(userProblem);
            userProblemDTOList.add(userProblemDTO);
        }
        return userProblemDTOList;
    }

    private UserProblemDTO mapUserProblemToUserProblemDTO(UserProblem userProblem) {

        return new UserProblemDTO(
                userProblem.getUser().getId(),
                userProblem.getProblem(),
                userProblem.getSolution(),
                userProblem.getSolved()
        );
    }


    private boolean checkTrue(List<CompileResult> compileResults) {
        for (CompileResult compileResult : compileResults)
            if (!compileResult.isSuccess())
                return false;
        return true;
    }

    private void addUserProblem(UserProblemDTO userProblemDTO, boolean isSuccess) {

        Optional<UserProblem> optionalUserProblem = userProblemRepository.getUserProblemByProblemIdAndUserId(
                userProblemDTO.getProblem().getId(),
                userProblemDTO.getUserId());

        UserProblem userProblem;
        if (optionalUserProblem.isEmpty()) {
            userProblem = new UserProblem();
            userProblem.setProblem(userProblemDTO.getProblem());
            userProblem.setUser(userRepository.findById(userProblemDTO.getUserId()).get());
        } else
            userProblem = optionalUserProblem.get();


        userProblem.setSolution(userProblemDTO.getSolution());
        userProblem.setSolved(isSuccess);
        userProblemRepository.save(userProblem);
    }



}
