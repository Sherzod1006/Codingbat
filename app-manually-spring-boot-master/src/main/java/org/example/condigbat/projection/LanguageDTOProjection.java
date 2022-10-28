package org.example.condigbat.projection;

public interface LanguageDTOProjection {

    Integer getId();

    String getTitle();

    String getUrl();

    Integer getSectionCount();

    Integer getProblemCount();

    Long getTryCount();

    Long getSolutionCount();
}
