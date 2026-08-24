package com.employee.employee_leave_management.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EmployeeLeave {

    private int employeeId;

    @NotBlank(message = "Employee name is required")
    private String employeeName;

    @NotBlank(message = "Leave type is mandatory")
    private String leaveType;

    @Min(value = 1, message = "Leave days should be minimum 1")
    private int numberOfDays;

    private String reason;


    // Default Constructor
    public EmployeeLeave() {
    }


    // Parameterized Constructor
    public EmployeeLeave(int employeeId, String employeeName,
                         String leaveType, int numberOfDays,
                         String reason) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.leaveType = leaveType;
        this.numberOfDays = numberOfDays;
        this.reason = reason;
    }


    // Getter and Setter for employeeId
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    // Getter and Setter for employeeName
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


    // Getter and Setter for leaveType
    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }


    // Getter and Setter for numberOfDays
    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }


    // Getter and Setter for reason
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}