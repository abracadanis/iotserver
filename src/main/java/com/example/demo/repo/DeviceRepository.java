package com.example.demo.repo;

import com.example.demo.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query("SELECT c FROM Device c where c.key = ?1")
    Optional<Device> findByKey(String key);

    void deleteByKey(String key);

}
