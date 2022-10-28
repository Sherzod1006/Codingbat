package org.example.condigbat.payload;


import lombok.Getter;

@Getter
public class AddSectionDTO {
    private String title;

    private String description;

    private Byte maxRate;

    private Integer languageId;
}
