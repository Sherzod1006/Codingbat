package org.example.condigbat.service;

import org.example.condigbat.entity.Section;
import org.example.condigbat.payload.AddSectionDTO;
import org.example.condigbat.payload.ApiResult;
import org.example.condigbat.payload.SectionDTO;
import org.example.condigbat.payload.ViewDTO;
import org.example.condigbat.projection.SectionDTOProjection;

import java.util.List;

public interface SectionService {
    ApiResult<SectionDTO> add(AddSectionDTO sectionDTO);

    ApiResult<SectionDTO> getSection(Integer id);

    ApiResult<?> delete(Integer id);

    ApiResult<SectionDTO> edit(AddSectionDTO addSectionDTO, Integer id);

    ApiResult<List<SectionDTOProjection>> getSections(ViewDTO viewDTO, int page, int size);

    ApiResult<List<SectionDTO>> getSectionsForUser();


}
