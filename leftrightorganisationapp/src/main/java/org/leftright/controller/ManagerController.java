package org.leftright.controller;

import org.leftright.customexception.RecordNotFoundException;
import org.leftright.model.TaskDetailsModel;
import org.leftright.service.TaskDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ManagerController {

    @Autowired
    TaskDetailsService taskDetailsServiceImpl;

    @PostMapping("/assigntask")
    public ResponseEntity<TaskDetailsModel> assignTask(@RequestBody TaskDetailsModel taskDetailsModel) {
        return ResponseEntity.ok(taskDetailsServiceImpl.assignTask(taskDetailsModel));
    }

    @GetMapping("/gettaskdetails/{taskId}")
    public ResponseEntity<TaskDetailsModel> getTaskDetails(@PathVariable int taskId) {
        return ResponseEntity.ok(taskDetailsServiceImpl.getTaskDetails(taskId));
    }

    @PutMapping("/updatetaskdetails/{taskId}")
    public ResponseEntity<String> updateTaskDetails(@RequestBody TaskDetailsModel taskDetailsModel, @PathVariable int taskId)
    {
        String ss="";

        try {
            taskDetailsServiceImpl.updateTaskDetails(taskDetailsModel, taskId);
            ss="Data updated successully";
        } catch (RecordNotFoundException e) {
            ss=e.getMessage();
        }
        return ResponseEntity.ok(ss);
    }

    @DeleteMapping("/deletetaskbyid/{taskId}")
    public ResponseEntity<String> deleteTaskById(@PathVariable int  taskId)
    {
        String ss="";

        try {
            ss =taskDetailsServiceImpl.deleteTaskById(taskId);

        } catch (RecordNotFoundException e) {
            ss=e.getMessage();
        }
        return ResponseEntity.ok(ss);

    }

}
