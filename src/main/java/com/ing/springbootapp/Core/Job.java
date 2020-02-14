package com.ing.springbootapp.Core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {
    private long id;
    private String jobDesc;
    private String jobPos;

}
