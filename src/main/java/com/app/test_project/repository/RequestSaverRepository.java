package com.app.test_project.repository;

import com.app.test_project.model.RequestHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RequestSaverRepository extends CrudRepository<RequestHistory, Long> {

}
