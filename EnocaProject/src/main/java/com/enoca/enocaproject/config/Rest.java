package com.enoca.enocaproject.config;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rest {
    private Boolean status;
    private Object result;
}
