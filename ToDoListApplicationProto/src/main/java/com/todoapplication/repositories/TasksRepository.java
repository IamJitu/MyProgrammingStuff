package com.todoapplication.repositories;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.todoapplication.models.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

	@Query("select new map (T.id as id, T.taskname as taskname, T.performdate as performdate, T.category as category, T.priority as priority, T.isdone as isdone) from Tasks T")
	Collection<Tasks> findAllCustom();

	Tasks findById(long id);

}
