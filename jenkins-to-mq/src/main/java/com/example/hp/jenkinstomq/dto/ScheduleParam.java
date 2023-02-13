package com.example.hp.jenkinstomq.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author T828155V
 * @date 02/13/23
 * @description: TODO
 */
@Data
@NoArgsConstructor
public class ScheduleParam {
    private String type;
    private String param;
}
