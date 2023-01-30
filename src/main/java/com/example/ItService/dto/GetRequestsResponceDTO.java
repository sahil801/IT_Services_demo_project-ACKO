package com.example.ItService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetRequestsResponceDTO {
    private boolean status;
    private String message;
    private List<RequestCustomerDTO> data;
}