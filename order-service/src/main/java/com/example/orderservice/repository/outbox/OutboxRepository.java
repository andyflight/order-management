package com.example.orderservice.repository.outbox;

import com.example.orderservice.domain.outbox.OutboxStatus;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public interface OutboxRepository extends JpaRepository<DBOutbox, UUID> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({
            @QueryHint(name = "jakarta.persistence.lock.timeout", value = "-2")
    })
    @Query("SELECT o FROM DBOutbox o WHERE o.status = :status AND o.createdAt < :before")
    List<DBOutbox> findStaleEvents(
            @Param("status") OutboxStatus status,
            @Param("before") Instant before,
            Limit limit
    );

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE DBOutbox o SET o.status = :newStatus WHERE o.id = :id AND o.status = :currentStatus")
    int updateStatus(
            @Param("id") UUID id,
            @Param("currentStatus") OutboxStatus currentStatus,
            @Param("newStatus") OutboxStatus newStatus
    );
}
