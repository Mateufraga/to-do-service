package Demo.controller.service;

import Demo.controller.model.TaskModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service

public class TaskService {
    public ArrayList<TaskModel> tasks = new ArrayList<TaskModel>();

    public void listTasks(ArrayList<TaskModel> tasks) {
        System.out.println("Tarefas adicionadas!: ");
        for (TaskModel x : tasks) {
            System.out.println("----------");
            System.out.println("Id: " + x.id);
            System.out.println("Descrição: " + x.descricao);
            System.out.println("Data de Expiração: " + x.dataDeExpiracao);
            System.out.println("Concluída: " + x.concluida);
            System.out.println("----------");
        }
    }

    public ResponseEntity<TaskModel> addTask(TaskModel task) {
        try {
            System.out.println(task.id);
            System.out.println(task.descricao);
            System.out.println(task.dataDeExpiracao);
            System.out.println(task.concluida);
            tasks.add(task);
            return new ResponseEntity("Task adicionada com sucesso.", HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity("Erro.", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> editTaskPostMapping(String taskId, TaskModel taskToEdit) {
        for (TaskModel task : tasks) {
            if (task.getId().equals(taskId)) {
                task.id = taskToEdit.id;
                task.descricao = taskToEdit.descricao;
                task.dataDeExpiracao = taskToEdit.dataDeExpiracao;
                task.concluida = taskToEdit.concluida;
                return ResponseEntity.ok("Modificação feita com sucesso");
            }
        }
        return new ResponseEntity<>("ID inexistente.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteTask(String taskId) {
        for (TaskModel task : tasks) {
            if (task.getId().equals(taskId)) {
                tasks.remove(task);
                return ResponseEntity.ok("Tarefa de id " + taskId + " foi removida com sucesso");
            }
        }
        return ResponseEntity.ofNullable("ID inexistente.");
    }
}