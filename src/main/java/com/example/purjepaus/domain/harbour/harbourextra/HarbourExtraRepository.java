package com.example.purjepaus.domain.harbour.harbourextra;

import com.example.purjepaus.domain.harbour.Harbour;
import com.example.purjepaus.domain.harbour.extra.Extra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HarbourExtraRepository extends JpaRepository<HarbourExtra, Integer> {
    @Query("select h.extra from HarbourExtra h where h.harbour.id = ?1")
    List<Extra> findExtrasBy(Integer harbourId);

    @Query("select h from HarbourExtra h where h.harbour.id = ?1 and h.extra.id = ?2")
    HarbourExtra findHarbourExtraBy(Integer harbourId, Integer extraId);

    @Query("SELECT h FROM Harbour h WHERE h.id IN (SELECT he.harbour.id FROM HarbourExtra he WHERE he.isAvailable = true GROUP BY he.harbour.id HAVING COUNT(DISTINCT he.id) >= ALL (SELECT COUNT(DISTINCT he2.id)\n" +
            "    FROM HarbourExtra he2 WHERE he2.isAvailable = true GROUP BY he2.harbour.id))")
    List<Harbour> findHarboursByMatching(List<Integer> extraIds);

}