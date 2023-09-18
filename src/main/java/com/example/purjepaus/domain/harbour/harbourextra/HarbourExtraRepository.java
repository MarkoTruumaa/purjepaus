package com.example.purjepaus.domain.harbour.harbourextra;

import com.example.purjepaus.domain.harbour.extra.Extra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HarbourExtraRepository extends JpaRepository<HarbourExtra, Integer> {
    @Query("select h.extra from HarbourExtra h where h.harbour.id = ?1")
    List<Extra> findExtrasBy(Integer harbourId);

    @Query("select h from HarbourExtra h where h.harbour.id = ?1 and h.extra.id = ?2")
    HarbourExtra findHarbourExtraBy(Integer harbourId, Integer extraId);

    @Query("SELECT he.harbour.id FROM HarbourExtra he WHERE he.extra.id IN :extraIds AND he.isAvailable = true GROUP BY he.harbour.id HAVING COUNT(DISTINCT he.extra.id) = :count")
    List<Integer> findHarboursIdsByMatching(List<Integer> extraIds, int count);

}