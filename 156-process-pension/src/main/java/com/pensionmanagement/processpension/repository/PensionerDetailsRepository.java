package com.pensionmanagement.processpension.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pensionmanagement.processpension.model.PensionDetails;

public interface PensionerDetailsRepository extends JpaRepository<PensionDetails, Integer> {

}
