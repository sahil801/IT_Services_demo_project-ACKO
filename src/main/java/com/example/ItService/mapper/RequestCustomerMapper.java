package com.example.ItService.mapper;

import com.example.ItService.dto.RequestCustomerDTO;
import com.example.ItService.enums.requestStatusType;
import com.example.ItService.model.Customer;
import com.example.ItService.model.Request;

public class RequestCustomerMapper {
    public static Customer toCustomer(RequestCustomerDTO requestCustomerDTO){
        if( requestCustomerDTO==  null) return  null;
        Customer customer = new Customer();
        customer.setName(requestCustomerDTO.getCustomerName());
        customer.setEmail(requestCustomerDTO.getCustomerEmail());
        customer.setPhone(requestCustomerDTO.getCustomerPhone());
        return  customer;
    }
    public static Request toRequest(RequestCustomerDTO requestCustomerDTO){
        if(requestCustomerDTO == null) return null;
        Request request = new Request();
        if(requestCustomerDTO.getRequestStatus()!=null) {
            request.setRequestStatus(requestStatusType.valueOf(requestCustomerDTO.getRequestStatus()));
        }
        request.setDetails(requestCustomerDTO.getRequestDetails());
        return request;
    }
    public static RequestCustomerDTO EntityToRequestCustomerDTO(Request request){
        if(request == null) return null;
        return RequestCustomerDTO.builder()
                .requestId(request.getId())
                .customerName(request.getCustomer().getName())
                .customerEmail(request.getCustomer().getEmail())
                .customerPhone(request.getCustomer().getPhone())
                .requestDetails(request.getDetails())
                .requestStatus(String.valueOf(request.getRequestStatus()))
                .build();
    }
    public static RequestCustomerDTO CustomerToRequestCustomerDTO(Customer customer){
        if (customer == null) return null;
        return RequestCustomerDTO.builder()
                .customerName(customer.getName())
                .customerEmail(customer.getEmail())
                .customerPhone(customer.getPhone())
                .build();
    }
}
