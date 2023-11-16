package com.example.tasktracker.Controller;

import com.example.tasktracker.Api.Api;
import com.example.tasktracker.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/ap1/v1/task")

public class Taskcontroller {
    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getTasks() {
        return tasks;
    }

    @PostMapping("/add")
    public Api addTasks(@RequestBody Task task) {
        tasks.add(task);
        return new Api("Task add", 200);

    }

    @PutMapping("/update/{index}")
    public Api updateTasks(@PathVariable int index, @RequestBody Task task) {
        tasks.set(index, task);
        return new Api("Task updated", 200);
    }

    @DeleteMapping("/delete/{index}")
    public Api deleteTasks(@PathVariable int index) {
        tasks.remove(index);
        return new Api("Task deleted", 200);
    }

    @PutMapping("/change/{index}")
    public Api change(@PathVariable int index) {
        Task task = tasks.get(index);
        if (task.getStatus().equals("not done")) {
            task.setStatus("done");
            tasks.set(index, task);
        }
        if (task.getStatus().equals("done")) {
            task.setStatus("not done");
            tasks.set(index, task);

        }
        return new Api("Status changed", 200);
    }

    @GetMapping("/search/{title}")
    public Api search(@PathVariable String title) {

        for (Task task : tasks) {
            if (task.getTitle().equals(title))
                return new Api("The Task Found", 200);
        }
        return new Api("Task not Found", 400);

    }
}