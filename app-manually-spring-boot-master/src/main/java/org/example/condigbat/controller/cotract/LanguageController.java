package org.example.condigbat.controller.cotract;

import org.example.condigbat.payload.AddLanguageDTO;
import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.LanguageDTO;
import org.example.condigbat.payload.ViewDTO;
import org.example.condigbat.projection.LanguageDTOProjection;
import org.example.condigbat.util.RestConstants;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;


@RequestMapping(path = "/api/language")
public interface LanguageController {

    @PostMapping(path = "/add")
    ApiResult<LanguageDTO> add(@Valid @RequestBody AddLanguageDTO addLanguageDTO);


    @PostMapping("/list")
    ApiResult<List<LanguageDTOProjection>> getLanguages (@RequestBody(required = false) ViewDTO viewDTO,
                                                         @RequestParam(defaultValue = RestConstants.DEFAULT_PAGE_NUMBER) int page,
                                                         @RequestParam(defaultValue = RestConstants.DEFAULT_PAGE_SIZE) int size);

    @GetMapping("/{id}")
    ApiResult<LanguageDTO> getLanguage(@PathVariable
            @NotNull(message = "Id must be not null") Integer id);

    @DeleteMapping("/{id}")
    ApiResult<?> delete(@PathVariable @NotNull Integer id);


    @PutMapping("/{id}")
    ApiResult<LanguageDTO> edit(@Valid @RequestBody AddLanguageDTO addLanguageDTO,
                                @PathVariable Integer id);


    @GetMapping("/list-for-users")
    ApiResult<List<LanguageDTO>> getLanguagesForUser();


}
