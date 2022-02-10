package com.santosh.springbootjpa.model;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "percentage_complete", nullable = false)
    private Integer percentageComplete;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_date", nullable = false)
    private Date addedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_modified_date", nullable = false)
    private Date lastModifiedDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @ManyToOne()
    private User owner;

    @JoinColumn(name = "project_type_id", referencedColumnName = "id")
    @ManyToOne()
    private ProjectType projectType;

    @OneToMany(mappedBy = "project")
    @Fetch(FetchMode.SUBSELECT)
    private List<Task> tasks;

    public Project(Integer id) {
        this.id = id;
    }
}
