package org.example.condigbat.controller.implementation;

import lombok.RequiredArgsConstructor;
import org.example.condigbat.controller.cotract.SectionController;
import org.example.condigbat.payload.AddSectionDTO;
import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.SectionDTO;
import org.example.condigbat.payload.ViewDTO;
import org.example.condigbat.projection.SectionDTOProjection;
import org.example.condigbat.service.SectionService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class SectionControllerImpl implements SectionController {

    private final SectionService sectionService;

    @Override
    public ApiResult<SectionDTO> add(AddSectionDTO sectionDTO) {
        return sectionService.add(sectionDTO);
    }

    @Override
    public ApiResult<List<SectionDTOProjection>> getSections(ViewDTO viewDTO, int page, int size) {
        return sectionService.getSections(viewDTO,page,size);
    }

    @Override
    public ApiResult<SectionDTO> getSection(Integer id) {
        return sectionService.getSection(id);
    }

    @Override
    public ApiResult<?> deleteSection(Integer id) {
        return sectionService.delete(id);
    }

    @Override
    public ApiResult<SectionDTO> editSection(AddSectionDTO sectionDTO, Integer id) {
        return sectionService.edit(sectionDTO,id);
    }

    @Override
    public ApiResult<List<SectionDTO>> getSectionsForUser() {
        return sectionService.getSectionsForUser();
    }
}
