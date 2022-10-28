package org.example.condigbat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.condigbat.entity.template.AbsLongEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cases",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"args", "problem_id"}))
public class Case extends AbsLongEntity {

    @Column(nullable = false, columnDefinition = "text")
    private String args;

    @Column(nullable = false, columnDefinition = "text")
    private String expected;

    @Column(nullable = false)
    private Boolean visible;

    @ManyToOne(optional = false)
    private Problem problem;
}