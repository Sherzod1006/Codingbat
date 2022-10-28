package org.example.condigbat.repository;

import org.example.condigbat.entity.Language;
import org.example.condigbat.payload.LanguageDTO;
import org.example.condigbat.projection.LanguageDTOProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

    boolean existsByTitle(String title);

    List<Language> findAllByTitleIsNotNull();

    List<Language> findAllByUrlIsNotNull();

    List<Language> findAllByTitleIsNull();

    List<Language> findAllByUrlIsNull();

    List<Language> findAllByTitleNotContainingIgnoreCase(String title);

    List<Language> findAllByUrlNotContainingIgnoreCase(String title);

    List<Language> findAllByTitleContainingIgnoreCase(String title);

    List<Language> findAllByUrlContainingIgnoreCase(String title);

    @Query(value = "SELECT * FROM get_result_of_query(:query)", nativeQuery = true)
    List<LanguageDTOProjection> getLanguagesByStringQuery(String query);

    @Query(value = "SELECT l.*,\n" +
            "       COUNT(s.id)                               AS sectionCount,\n" +
            "       COUNT(p.id)                               AS problem_count,\n" +
            "       COUNT(up.id)                              AS try_count,\n" +
            "       COUNT(CASE WHEN up.solved THEN up.id END) AS solution_count\n" +
            "FROM language l\n" +
            "         LEFT JOIN section s on l.id = s.language_id\n" +
            "         LEFT JOIN problem p on s.id = p.section_id\n" +
            "         LEFT JOIN user_problem up on p.id = up.problem_id\n" +
            "GROUP BY l.id, l.title\n" +
            "ORDER BY title\n" +
            "LIMIT 10 OFFSET 0",nativeQuery = true)
    List<LanguageDTOProjection> getTest();

    boolean existsByTitleIgnoreCase(String title);
}
