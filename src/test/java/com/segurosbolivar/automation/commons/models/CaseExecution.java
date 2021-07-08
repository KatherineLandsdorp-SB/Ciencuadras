package com.segurosbolivar.automation.commons.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CaseExecution {
    public Integer id;
    public Integer idExecution;
    public Integer idCase;
    public Integer idStateExecution;
    public String startDate;
    public String endDate;
    public String dataInputExecution;
    public String dataOutputExecution;
    public String dataOutputPerformance;
}
