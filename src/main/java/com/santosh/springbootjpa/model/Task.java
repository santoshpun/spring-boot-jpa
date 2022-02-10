package com.santosh.springbootjpa.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @Column(name = "summary", nullable = false, length = 50)
    private String summary;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "percentage_complete", nullable = false)
    private Integer percentageComplete;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_date", nullable = false)
    private Date dueDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_date", nullable = false)
    private Date lastModifiedDate;

    @JoinColumn(name = "reporter_id", referencedColumnName = "id")
    @ManyToOne()
    private User reporter;

    @JoinColumn(name = "assignee_id", referencedColumnName = "id")
    @ManyToOne()
    private User assignee;

    @JoinColumn(name = "issue_type_id", referencedColumnName = "id")
    @ManyToOne()
    private IssueType issueType;

    @JoinColumn(name = "project_id", referencedColumnName = "id")
    @ManyToOne()
    private Project project;

    public Task(Integer id) {
        this.id = id;
    }
}
