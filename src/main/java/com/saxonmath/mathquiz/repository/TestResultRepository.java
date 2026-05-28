package com.saxonmath.mathquiz.repository;

import com.saxonmath.mathquiz.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    List<TestResult> findByUserIdOrderByCompletedAtDesc(Long userId);
    List<TestResult> findByUserId(Long userId);
    Optional<TestResult> findTopByUserIdAndTestIdOrderByCompletedAtDesc(Long userId, Long testId);
    long countByUserId(Long userId);
}
