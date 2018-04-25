package com.todoapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todoapplication.models.Tasks;
@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
	List<Tasks> findByTaskarchived(@Param("archivedfalse") int taskArchivedFalse);

	List<Tasks> findByTaskstatus(@Param("status") String taskstatus);

}
