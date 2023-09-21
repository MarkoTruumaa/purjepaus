package com.example.purjepaus.domain.harbour.harbourextra;

import com.example.purjepaus.domain.harbour.Harbour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface HarbourExtraRepository extends JpaRepository<HarbourExtra, Integer> {
    @Query("select h from HarbourExtra h where h.harbour.id = ?1")
    List<HarbourExtra> findHarbourExtrasBy(Integer harbourId);

    @Query("select h from HarbourExtra h where h.harbour.id = ?1 and h.extra.id = ?2")
    HarbourExtra findHarbourExtraBy(Integer harbourId, Integer extraId);

    @Query("SELECT he.harbour FROM HarbourExtra he WHERE he.extra.id IN :extraIds AND he.isAvailable = true  AND (he.harbour.location.county.id = :countyId or :countyId = 0) AND he.harbour.minDepth >= :minDepth AND he.harbour.minWidth >= :minWidth GROUP BY he.harbour HAVING COUNT(DISTINCT he.extra.id) = :count")
    List<Harbour> findHarboursIdsByMatching(List<Integer> extraIds, int count, Integer countyId, BigDecimal minDepth, BigDecimal minWidth);
}