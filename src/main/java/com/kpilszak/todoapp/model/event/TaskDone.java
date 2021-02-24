package com.kpilszak.todoapp.model.event;

import com.kpilszak.todoapp.model.Task;

import java.time.Clock;

public class TaskDone extends TaskEvent {
	TaskDone(final Task source) {
		super(source.getId(), Clock.systemDefaultZone());
	}
}
