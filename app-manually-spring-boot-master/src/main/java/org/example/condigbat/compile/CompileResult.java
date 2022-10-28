package org.example.condigbat.compile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.condigbat.entity.Case;
@Getter
@AllArgsConstructor
public class CompileResult {

    private Case aCase;

    private String userAnswer;

    private boolean isSuccess;



}
