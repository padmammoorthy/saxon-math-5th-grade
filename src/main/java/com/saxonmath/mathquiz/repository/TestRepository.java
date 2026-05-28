package com.saxonmath.mathquiz.repository;

import com.saxonmath.mathquiz.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findByDifficultyOrderByNameAsc(Test.Difficulty difficulty);
}
