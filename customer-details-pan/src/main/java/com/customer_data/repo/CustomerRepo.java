package com.customer_data.repo;

import com.customer_data.custbycif.CustDetailsByCif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustDetailsByCif, String >
{
}
