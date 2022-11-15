package org.leftright.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDetailsModel {

    @Id
    @GeneratedValue
    private int taskId;

    private String taskName;

    private String taskDetails;

    private String taskAssigner;

    private String taskAssignedTo;

    private String taskCreatedOn;

    private String taskStatus;

}
