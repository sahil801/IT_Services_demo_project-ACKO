package com.example.ItService.service;

import com.example.ItService.dto.GetRequestsResponceDTO;
import com.example.ItService.dto.RequestCustomerDTO;
import com.example.ItService.model.Request;

import java.util.List;

public interface RequestService {
    GetRequestsResponceDTO getAllRequests();
    GetRequestsResponceDTO getRequestById(long id);
    long addRequest(RequestCustomerDTO requestCustomerDTO);
    GetRequestsResponceDTO updateRequest(long id, RequestCustomerDTO requestCustomerDTO);
    GetRequestsResponceDTO deleteRequest(long id);
}
