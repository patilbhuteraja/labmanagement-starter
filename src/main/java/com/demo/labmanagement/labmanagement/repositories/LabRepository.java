package com.demo.labmanagement.labmanagement.repositories;

import org.springframework.data.repository.CrudRepository;
import com.demo.labmanagement.labmanagement.models.LabDto;

public interface LabRepository extends CrudRepository<LabDto, Long> {
}
