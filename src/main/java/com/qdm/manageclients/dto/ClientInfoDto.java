package com.qdm.manageclients.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfoDto {

    private String client_name;
    private String gender;
    private int age;
    private String mobile_no;
    private String latitude;
    private String longitude;
 
}
