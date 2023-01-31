package com.example.ItService.dto;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Optional;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestCustomerDTO {
    private long requestId;
    private String customerName;
    @NotEmpty(message = "email can not be empty")
    @Email(message = "enter valid email address",regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String customerEmail;

    @NotEmpty(message = "phone number can not be empty")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Phone number must be of 10 digits")
    private String customerPhone;
    private String requestDetails;
    private String requestStatus;
//    private Optional<Boolean> isDeleted;
}
