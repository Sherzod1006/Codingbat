package org.example.condigbat.repository;

import org.example.condigbat.entity.Section;
import org.example.condigbat.projection.SectionDTOProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SectionRepository extends JpaRepository<Section, Integer> {
    long countAllByLanguageId(Integer languageId);
    Section getByTitle(String title);

    List<Section> getAllByLanguage_Id(Integer languageId);

    void deleteAllByLanguage_Id(Integer languageId);

    boolean existsByLanguageId(Integer id);

    boolean existsByTitle(String title);

    @Query(value = "SELECT * FROM get_result_of_query_section(:query)", nativeQuery = true)
    List<SectionDTOProjection> getSectionsByStringQuery(String query);
}
