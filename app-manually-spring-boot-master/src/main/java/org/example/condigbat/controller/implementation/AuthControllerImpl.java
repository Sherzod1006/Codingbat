package org.example.condigbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.condigbat.controller.cotract.AuthController;
import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.SignDTO;
import org.example.condigbat.payload.TokenDTO;
import org.example.condigbat.repository.UserDetailsRepository;
import org.example.condigbat.service.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@Slf4j
public class AuthControllerImpl implements AuthController {

    private final AuthService authService;
    private final UserDetailsRepository userDetailsRepository;


    public ApiResult<Boolean> signUp(@RequestBody @Valid SignDTO signDTO) {
        log.info("SIgn up method entered: {}", signDTO);
        ApiResult<Boolean> apiResult = authService.signUp(signDTO);
        log.info("SIgn up method exited: {}", apiResult);
        return apiResult;
    }

    public ApiResult<?> verificationEmail(@RequestParam String email) {
        log.info("SIgn in method entered: {}", email);
        return authService.verificationEmail(email);
    }

    @Override
    public ApiResult<TokenDTO> signIn(SignDTO signDTO) {
        log.info("SIgn in method entered: {}", signDTO);
        ApiResult<TokenDTO> apiResult = authService.signIn(signDTO);
        log.info("SIgn in method exited: {}", apiResult);
        return apiResult;
    }
}
