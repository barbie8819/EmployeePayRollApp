package com.BridgeLabz.EmployeePayRollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeePayrollDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Invalid Name format")
    private String name;

    @Min(value = 3000, message = "Salary must be greater than 3000")
    private double salary;

    @NotEmpty(message = "Gender cannot be empty")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotNull(message = "Start Date cannot be empty")
    @PastOrPresent(message = "Start Date should not be a future date")
    @JsonFormat(pattern = "dd MMM yyyy") // Ensures JSON format is correct
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be blank") // Ensures it's not blank
    private String note;

    @NotBlank(message = "Profile picture URL cannot be blank") // Ensures it's not blank
    private String profilePic;

    @NotEmpty(message = "Department cannot be empty")
    private List<String> department;
}
