package org.example.condigbat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.example.condigbat.entity.template.AbsTitleIntegerEntity;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(uniqueConstraints =
@UniqueConstraint(
        columnNames = {"title", "section_id"}
))
public class Problem extends AbsTitleIntegerEntity {

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    private String methodSignature;

    @ManyToOne(optional = false)
    private Section section;

    @JsonIgnore
    @OneToMany(mappedBy = "problem")
    private List<Case> cases;
}
