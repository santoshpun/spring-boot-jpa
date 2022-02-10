package com.santosh.springbootjpa.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentResponse {
    private int id;
    private String name;
}
