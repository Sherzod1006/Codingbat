package org.example.condigbat.service;

import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.SignDTO;
import org.example.condigbat.payload.TokenDTO;


public interface AuthService {
    ApiResult<Boolean> signUp(SignDTO signDTO);

    ApiResult<?> verificationEmail(String email);

    ApiResult<TokenDTO> signIn(SignDTO signDTO);
}
