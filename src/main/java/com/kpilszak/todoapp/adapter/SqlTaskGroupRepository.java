package com.kpilszak.todoapp.adapter;

import com.kpilszak.todoapp.model.TaskGroup;
import com.kpilszak.todoapp.model.TaskGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlTaskGroupRepository extends TaskGroupRepository, JpaRepository<TaskGroup, Integer> {
}
