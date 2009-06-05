package com.ideature.loanapp.dto;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class BaseDTO {

    /**
     * Method to get a String representing the current state of the DTO.
     *
     * @return retStr is string of fields listed in the DTO
     */
    public String toString()
    {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
