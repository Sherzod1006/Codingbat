package org.example.condigbat.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SectionDTO {
    private Integer id;

    private String title;

    private String url;

    private String description;

    private Byte maxRate;

    private Integer languageId;

    private Integer problemCount;

    private Long tryCount;

    private Long solutionCount;

    public SectionDTO(Integer id, String title, String url, String description, Byte maxRate, Integer languageId) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.description = description;
        this.maxRate = maxRate;
        this.languageId = languageId;
    }
}
