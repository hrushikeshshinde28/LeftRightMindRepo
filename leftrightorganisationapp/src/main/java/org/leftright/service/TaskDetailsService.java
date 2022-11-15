package org.leftright.service;

import org.leftright.customexception.RecordNotFoundException;
import org.leftright.model.TaskDetailsModel;
import org.leftright.repo.TaskDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TaskDetailsService {
    @Autowired
    TaskDetailsRepo taskDetailsRepoImpl;

    public TaskDetailsModel assignTask(TaskDetailsModel taskDetailsModel) {
        return taskDetailsRepoImpl.save(taskDetailsModel);
    }

    public TaskDetailsModel getTaskDetails(int taskId) {
        return taskDetailsRepoImpl.findById(taskId).get();
    }

    public void updateTaskDetails(TaskDetailsModel taskDetailsModel, int taskId) throws RecordNotFoundException {
        TaskDetailsModel updateHere = taskDetailsRepoImpl.findById(taskId).get();
        if (updateHere != null) {
            updateHere.setTaskId(taskId);
            updateHere.setTaskAssigner(taskDetailsModel.getTaskAssigner());
            updateHere.setTaskCreatedOn(taskDetailsModel.getTaskCreatedOn());
            updateHere.setTaskName(taskDetailsModel.getTaskName());
            updateHere.setTaskStatus(taskDetailsModel.getTaskStatus());
            updateHere.setTaskAssignedTo(taskDetailsModel.getTaskAssignedTo());
            updateHere.setTaskDetails(taskDetailsModel.getTaskDetails());

            taskDetailsRepoImpl.save(updateHere);
        } else {
            throw new RecordNotFoundException("Invalid Task Id");
        }
    }

    public String deleteTaskById(int taskId) throws RecordNotFoundException {
        String ss = "";
        TaskDetailsModel tt = taskDetailsRepoImpl.findById(taskId).get();
        if (tt != null) {
            ss = "Task deleted successully";
        } else {
            throw new RecordNotFoundException("Invalid Task Id");
        }
        return ss;
    }

    public String updateTaskStatus(int taskId, String taskStatus, String taskAssignedTo) throws RecordNotFoundException {
        String s="";
        TaskDetailsModel updateHere = taskDetailsRepoImpl.findById(taskId).get();

        if (updateHere ==null )
        {
            throw new RecordNotFoundException("Invalid Task Id");
        }
        else {
            updateHere.setTaskStatus(taskStatus);
            taskDetailsRepoImpl.save(updateHere);
            s = taskAssignedTo + " your status updated sucessfully";
        }
        return s;

    }

}
