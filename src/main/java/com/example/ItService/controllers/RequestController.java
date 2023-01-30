package com.example.ItService.controllers;

import com.example.ItService.dto.GetRequestsResponceDTO;
import com.example.ItService.dto.RequestCustomerDTO;
import com.example.ItService.mapper.RequestCustomerMapper;
import com.example.ItService.model.Customer;
import com.example.ItService.model.Request;
import com.example.ItService.service.RequestService;
import org.slf4j.ILoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestController {
    @Autowired
    private RequestService requestService;
    @GetMapping("/requests")
    public ResponseEntity<GetRequestsResponceDTO> allRequests(){
        try {
            return new ResponseEntity<GetRequestsResponceDTO>(requestService.getAllRequests(), HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }
    @GetMapping("/request/{id}")
    public ResponseEntity<GetRequestsResponceDTO> getRequest(@PathVariable("id") long id){
        try {
            return new ResponseEntity<GetRequestsResponceDTO>(requestService.getRequestById(id),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }
    @PostMapping("/request")
    public ResponseEntity<Long> addRequest(@Validated @RequestBody RequestCustomerDTO requestCustomerDTO){
        try {
            long id = requestService.addRequest(requestCustomerDTO);
            return new ResponseEntity<Long>(id,HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }
    @PutMapping("/request/{id}")
    public ResponseEntity<GetRequestsResponceDTO> updateRequest(@PathVariable(value = "id") long id,@RequestBody RequestCustomerDTO requestCustomerDTO){
        try {
            return  new ResponseEntity<>(requestService.updateRequest(id,requestCustomerDTO),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }
    @DeleteMapping("request/{id}")
    public ResponseEntity<GetRequestsResponceDTO> deleteRequest(@PathVariable(value = "id") long id){
        try {
            return new ResponseEntity<>(requestService.deleteRequest(id),HttpStatus.OK);
        }catch (Exception e){
            throw e;
        }
    }
}
