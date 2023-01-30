package com.example.ItService.mapper;

import com.example.ItService.dto.GetRequestsResponceDTO;
import com.example.ItService.dto.RequestCustomerDTO;

import java.util.ArrayList;
import java.util.List;

public class GetRequestsResponceMapper {
    public static GetRequestsResponceDTO toGetRequestResponceDTO(RequestCustomerDTO requestCustomerDTO){
        if(requestCustomerDTO == null){
            return GetRequestsResponceDTO.builder()
                    .status(false)
                    .data(null)
                    .build();
        }else{
            List<RequestCustomerDTO> data = new ArrayList<>();
            data.add(requestCustomerDTO);
            return GetRequestsResponceDTO.builder()
                    .status(true)
                    .data(data)
                    .build();
        }
    }
    public static GetRequestsResponceDTO toGetRequestResponceDTO(List<RequestCustomerDTO> requestCustomerDTO){
        if(requestCustomerDTO == null){
            return GetRequestsResponceDTO.builder()
                    .status(false)
                    .data(null)
                    .build();
        }else{
            return GetRequestsResponceDTO.builder()
                    .status(true)
                    .data(requestCustomerDTO)
                    .build();
        }
    }
}
