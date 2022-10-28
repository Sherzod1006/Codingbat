package org.example.condigbat.controller.cotract;


import org.example.condigbat.payload.AddSectionDTO;
import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.SectionDTO;
import org.example.condigbat.payload.ViewDTO;
import org.example.condigbat.projection.SectionDTOProjection;
import org.example.condigbat.util.RestConstants;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "/api/section")
public interface SectionController {

    @PostMapping(path = "/add")
    ApiResult<SectionDTO> add(@Valid @RequestBody AddSectionDTO sectionDTO);

    @PostMapping (path = "/list")
    ApiResult<List<SectionDTOProjection>> getSections(@RequestBody(required = false) ViewDTO viewDTO,
                                                      @RequestParam(defaultValue = RestConstants.DEFAULT_PAGE_NUMBER) int page,
                                                      @RequestParam(defaultValue = RestConstants.DEFAULT_PAGE_SIZE) int size);

    @GetMapping(path = "/{id}")
    ApiResult<SectionDTO> getSection(@PathVariable Integer id);

    @DeleteMapping(path = "/{id}")
    ApiResult<?> deleteSection(@PathVariable Integer id);

    @PutMapping(path = "/{id}")
    ApiResult<SectionDTO> editSection(@RequestBody @Valid AddSectionDTO sectionDTO,
                                      @PathVariable Integer id);

    @GetMapping(path = "list-for-users")
    ApiResult<List<SectionDTO>> getSectionsForUser();
}
