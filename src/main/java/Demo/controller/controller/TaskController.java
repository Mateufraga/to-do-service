package Demo.controller.controller;

import Demo.controller.model.TaskModel;
import Demo.controller.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    public final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String listTasks() {
        return "Lista de tasks";
    }

    @PostMapping(value = "/tasks/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TaskModel> addTask(@RequestBody TaskModel task) {
        return taskService.addTask(task);
    }

    @PutMapping(value = "/tasks/edit/{taskId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> editTask(@PathVariable("taskId") String taskId, @RequestBody TaskModel taskToEdit) {
        return taskService.editTaskPostMapping(taskId, taskToEdit);
    }

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable("taskId") String taskId) {
        return taskService.deleteTask(taskId);
    }
}