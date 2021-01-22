package com.kpilszak.todoapp.logic;

import com.kpilszak.todoapp.TaskConfigurationProperties;
import com.kpilszak.todoapp.model.ProjectRepository;
import com.kpilszak.todoapp.model.TaskGroupRepository;
import com.kpilszak.todoapp.model.TaskRepository;
import org.springframework.context.annotation.Bean;

class LogicConfiguration {
	@Bean
	ProjectService projectService(
			final ProjectRepository repository,
			final TaskGroupRepository taskGroupRepository,
			final TaskGroupService taskGroupService,
			final TaskConfigurationProperties config
	) {
		return new ProjectService(repository, taskGroupRepository, taskGroupService, config);
	}
	
	@Bean
	TaskGroupService taskGroupService(
			final TaskGroupRepository taskGroupRepository,
			final TaskRepository taskRepository
	) {
		return new TaskGroupService(taskGroupRepository, taskRepository);
	}
}
