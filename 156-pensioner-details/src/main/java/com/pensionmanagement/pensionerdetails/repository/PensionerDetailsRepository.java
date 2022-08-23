package com.pensionmanagement.pensionerdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pensionmanagement.pensionerdetails.models.PensionerDetails;

@Repository
public interface PensionerDetailsRepository extends JpaRepository<PensionerDetails, String> {
}
