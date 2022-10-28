package org.example.condigbat.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.condigbat.entity.template.AbsTitleIntegerEntity;
import org.example.condigbat.util.CommonUtils;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"title"}))
@NoArgsConstructor
public final class Language extends AbsTitleIntegerEntity {

    @Column(unique = true, nullable = false)
    private String url;

    @JsonIgnore
    @OneToMany(mappedBy = "language")
    @Cascade(org.hibernate.annotations.CascadeType.REMOVE)
    private List<Section> sections;

    public Language(String title) {
        setTitle(title);
    }

    @PrePersist
    @PreUpdate
    private void setUrl() {
        this.url = CommonUtils.makeUrl(this.getTitle());
    }

}
