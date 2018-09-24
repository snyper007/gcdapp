package com.snyper.gcd.api.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.snyper.gcd.api.jpa.entity.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

}
