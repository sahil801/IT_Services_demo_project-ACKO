package com.example.ItService.serviceImpl;

import com.example.ItService.dto.GetRequestsResponceDTO;
import com.example.ItService.dto.RequestCustomerDTO;
import com.example.ItService.enums.requestStatusType;
import com.example.ItService.exception.ResourceNotFoundException;
import com.example.ItService.mapper.GetRequestsResponceMapper;
import com.example.ItService.mapper.RequestCustomerMapper;
import com.example.ItService.model.Customer;
import com.example.ItService.model.Request;
import com.example.ItService.service.CustomerService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.ItService.repository.RequestRepository;
import com.example.ItService.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private CustomerService customerService;
    @Override
    public GetRequestsResponceDTO getAllRequests() {
        List<RequestCustomerDTO> data = requestRepository.findByIsDeleted(false, Sort.by(Sort.Direction.DESC,
                        "id"))
                .stream()
                .map(RequestCustomerMapper::EntityToRequestCustomerDTO)
                .collect(Collectors.toList());
        GetRequestsResponceDTO response =  GetRequestsResponceMapper.toGetRequestResponceDTO(data);
        response.setMessage("success");
        return response;
    }
    @Override
    public GetRequestsResponceDTO getRequestById(long id){
        RequestCustomerDTO requestCustomerDTO = RequestCustomerMapper.EntityToRequestCustomerDTO(
                requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("request not found with id: " + id))
        );
        GetRequestsResponceDTO response =  GetRequestsResponceMapper.toGetRequestResponceDTO(requestCustomerDTO);
        response.setMessage("success");
        return response;
    }
    @Override
    public long addRequest(RequestCustomerDTO requestCustomerDTO){
        try{
            Customer newCustomer, prevCustomer;
            Optional<Customer>  customer = customerService.findFirstByPhone(requestCustomerDTO.getCustomerPhone());
            if(customer.isPresent()){
                newCustomer = customer.get();
                newCustomer.setName(requestCustomerDTO.getCustomerName());
                newCustomer.setEmail(requestCustomerDTO.getCustomerEmail());
            }else{
                newCustomer = RequestCustomerMapper.toCustomer(requestCustomerDTO);
            }
            Request request = RequestCustomerMapper.toRequest(requestCustomerDTO);
            request.setCustomer(newCustomer);
            requestRepository.save(request);
            return request.getId();
        }catch (RuntimeException runtimeException){
            throw runtimeException;
        }
    }
    @Override
    public GetRequestsResponceDTO updateRequest(long id, RequestCustomerDTO requestCustomerDTO){
        if(requestRepository.findById(id).isPresent()){
           Request existingRequest = requestRepository.getById(id);
           existingRequest.setRequestStatus(requestStatusType.valueOf(requestCustomerDTO.getRequestStatus()));
           existingRequest.setDetails(requestCustomerDTO.getRequestDetails());
           requestRepository.save(existingRequest);
           RequestCustomerDTO newRequestCustomerDTO = RequestCustomerMapper.EntityToRequestCustomerDTO(existingRequest);
           GetRequestsResponceDTO response =  GetRequestsResponceMapper.toGetRequestResponceDTO(newRequestCustomerDTO);
           response.setMessage("success");
           return response;
        }else{
            throw new ResourceNotFoundException("request not found with id: " + id);
        }
    }
    @Override
    public GetRequestsResponceDTO deleteRequest(long id){
        if(requestRepository.findById(id).isPresent()) {
            Request existingRequest = requestRepository.getById(id);
            existingRequest.setDeleted(true);
            requestRepository.save(existingRequest);
            RequestCustomerDTO newRequestCustomerDTO = RequestCustomerMapper.EntityToRequestCustomerDTO(existingRequest);
            GetRequestsResponceDTO response =  GetRequestsResponceMapper.toGetRequestResponceDTO(newRequestCustomerDTO);
            response.setMessage("the Request_id "+id+" has been deleted successfully");
            return response;
        }else{
            throw new ResourceNotFoundException("request not found with id: " + id);
        }
    }
}
