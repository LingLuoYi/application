package com.henglong.application.Repository;

import com.henglong.application.Entity.Accountnumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Accountnumber,Integer>{
}
