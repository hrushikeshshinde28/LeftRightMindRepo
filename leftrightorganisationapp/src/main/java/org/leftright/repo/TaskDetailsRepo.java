package org.leftright.repo;

import org.leftright.model.TaskDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDetailsRepo extends JpaRepository<TaskDetailsModel, Integer> {
      //custom methods
}
