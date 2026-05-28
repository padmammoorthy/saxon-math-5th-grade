package com.saxonmath.mathquiz.repository;

import com.saxonmath.mathquiz.model.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
    List<Badge> findByUserIdOrderByEarnedAtDesc(Long userId);
    boolean existsByUserIdAndBadgeName(Long userId, String badgeName);
}
