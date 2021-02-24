package com.kpilszak.todoapp.model.event;

import com.kpilszak.todoapp.model.Task;

import java.time.Clock;

public class TaskUndone extends TaskEvent {
	TaskUndone(final Task source) {
		super(source.getId(), Clock.systemDefaultZone());
	}
}
