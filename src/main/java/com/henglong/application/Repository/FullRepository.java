package com.henglong.application.Repository;

import com.henglong.application.Entity.FullName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullRepository extends JpaRepository<FullName,Integer> {


}
