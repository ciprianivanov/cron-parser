package com.cron.parser.interpreter.impl;

import com.cron.parser.interpreter.AbstractInterpreter;
import com.cron.parser.model.CronField;

import java.util.ArrayList;
import java.util.List;

import static com.cron.parser.util.CronUtils.RANGE_TOKEN;

public class RangeInterpreter extends AbstractInterpreter {

    public RangeInterpreter(CronField cronField) {
        super(cronField);
    }

    @Override
    public List<String> interpret() {
        List<String> executionTimes = new ArrayList<>();
        Integer start = getRangeStart();
        Integer end = getRangeEnd();
        for (int i = start; i <= end; i++) {
            executionTimes.add(String.valueOf(i));
        }
        return executionTimes;
    }

    private Integer getRangeStart() {
        return Integer.valueOf(cronField.getValue().split(RANGE_TOKEN)[0]);
    }

    private Integer getRangeEnd() {
        return Integer.valueOf(cronField.getValue().split(RANGE_TOKEN)[1]);
    }
}