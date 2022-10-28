package org.example.condigbat.projection;

public interface SectionDTOProjection {
    Integer getId();

    String getTitle();

    String getDescription();

    Byte getMaxRate();

    String getUrl();

    Integer getLanguageId();

    Integer getProblemCount();

    Long getTryCount();

    Long getSolutionCount();
}
