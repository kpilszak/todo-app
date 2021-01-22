package com.kpilszak.todoapp.logic;

import com.kpilszak.todoapp.model.TaskGroup;
import com.kpilszak.todoapp.model.TaskGroupRepository;
import com.kpilszak.todoapp.model.TaskRepository;
import com.kpilszak.todoapp.model.projection.GroupReadModel;
import com.kpilszak.todoapp.model.projection.GroupWriteModel;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequestScope
public class TaskGroupService {
    private TaskGroupRepository repository;
    private TaskRepository taskRepository;
    
    TaskGroupService(final TaskGroupRepository repository,
                     final TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;
    }
    
    public GroupReadModel createGroup(final GroupWriteModel source) {
        TaskGroup result = repository.save(source.toGroup());
        return new GroupReadModel(result);
    }
    
    public List<GroupReadModel> readAll() {
        return repository.findAll().stream()
                .map(GroupReadModel::new)
                .collect(Collectors.toList());
    }
    
    public void toggleGroup(int groupId) {
        if (taskRepository.existsByDoneIsFalseAndGroup_Id(groupId)) {
            throw new IllegalStateException("Group has undone tasks. Do all the tasks first.");
        }
        TaskGroup result = repository.findById(groupId).orElseThrow(() -> new IllegalArgumentException("TaskGroup with given id not found"));
        result.setDone(!result.isDone());
        repository.save(result);
    }
}
