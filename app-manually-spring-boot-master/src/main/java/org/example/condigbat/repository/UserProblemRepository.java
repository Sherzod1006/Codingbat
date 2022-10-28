package org.example.condigbat.repository;

import org.example.condigbat.entity.UserProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserProblemRepository
        extends JpaRepository<UserProblem, Long> {

    @Query("SELECT COUNT (up) FROM UserProblem up JOIN Problem p ON p = up.problem JOIN Section s ON s = p.section WHERE s.language.id = :languageId")
    long countAllByProblem_SectionLanguageIdJPQL(Integer languageId);

    long countAllBySolvedIsTrueAndProblem_SectionLanguageId(Integer problem_section_language_id);

    Optional<UserProblem> getUserProblemByProblemIdAndUserId(Integer userId, Integer problemId);

    long countAllByProblem_SectionId(Integer id);

    long countAllBySolvedIsTrueAndProblem_SectionId(Integer id);
}
