package org.example.condigbat.payload;


import lombok.*;
import org.example.condigbat.entity.Language;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddLanguageDTO {

    @NotBlank(message = "Title must be not blank")
    private String title;

    public Language get() {
        return new Language(title);
    }

}
