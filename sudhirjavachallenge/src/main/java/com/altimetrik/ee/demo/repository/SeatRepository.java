
package com.altimetrik.ee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.ee.demo.entity.BusSeatEntity;

public interface SeatRepository extends JpaRepository<BusSeatEntity, Long> {

}
