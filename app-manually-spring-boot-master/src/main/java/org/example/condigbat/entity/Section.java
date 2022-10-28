package org.example.condigbat.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.condigbat.entity.template.AbsTitleIntegerEntity;

import javax.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.example.condigbat.util.CommonUtils;
import org.hibernate.annotations.Cascade;


@Entity
@Setter
@Getter
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title", "language_id"}),
        @UniqueConstraint(columnNames = {"url", "language_id"}),
}
)
public class Section extends AbsTitleIntegerEntity {

    @Column(nullable = false)
    private String url;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(nullable = false)
    private Byte maxRate;

    @ManyToOne(optional = false)
    private Language language;

    @PrePersist
    @PreUpdate
    private void setUrl() {
        this.url = CommonUtils.makeUrl(this.getTitle());
    }

}
