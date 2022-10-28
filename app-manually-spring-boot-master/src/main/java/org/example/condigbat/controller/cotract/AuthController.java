package org.example.condigbat.controller.cotract;

import io.swagger.annotations.ApiOperation;
import org.example.condigbat.entity.UserDetails;
import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.SignDTO;
import org.example.condigbat.payload.TokenDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequestMapping(path = "/api/auth")
public interface AuthController {
    @ApiOperation(value = "Sign up path")
    @PostMapping(value = "/sign-up")
    ApiResult<Boolean> signUp(@RequestBody @Valid SignDTO signDTO);

    @ApiOperation(value = "Varification path")
    @GetMapping(value = "/verification-email")
    ApiResult<?> verificationEmail(@RequestParam String email);

    @ApiOperation(value = "Sign in path")
    @PostMapping(value = "/sign-in")
    ApiResult<TokenDTO> signIn(@Valid @RequestBody SignDTO signDTO);

}
