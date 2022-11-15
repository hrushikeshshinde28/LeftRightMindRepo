package org.leftright.controller;

import org.leftright.customexception.RecordNotFoundException;
import org.leftright.model.TaskDetailsModel;
import org.leftright.service.TaskDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TeamMemberController {

    @Autowired
    TaskDetailsService taskDetailsServiceImpl;

    @GetMapping("/get_task_details_of_team_members/{taskId}")
    public ResponseEntity<TaskDetailsModel> getTaskDetailsOfTeamMembers(@PathVariable int taskId) {
        return ResponseEntity.ok(taskDetailsServiceImpl.getTaskDetails(taskId));
    }

    @PatchMapping("/updateTaskStatus/{taskId}/{taskStatus}/{taskAssignedTo}")
    public ResponseEntity<String> updateTaskStatus(@PathVariable int taskId, @PathVariable String taskStatus, @PathVariable String taskAssignedTo) {
        String ss = "";
        try {
            taskDetailsServiceImpl.updateTaskStatus(taskId, taskStatus, taskAssignedTo);
        } catch (RecordNotFoundException e) {
            ss = e.getMessage();
        }

        return ResponseEntity.ok(ss);
    }

}
