package org.example.condigbat.repository;

import org.example.condigbat.entity.Case;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CaseRepository extends JpaRepository<Case,Long> {
    void deleteAllByProblem_Id(Integer problemId);

    List<Case> getAllByProblemId(Integer problemId);

    void deleteCasesByProblem_Id(Integer id);
}
