package com.employee.employee_leave_management.controller;

import com.employee.employee_leave_management.model.EmployeeLeave;
import com.employee.employee_leave_management.service.LeaveService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leaves")
public class LeaveController {

    private final LeaveService leaveService;

    // Constructor Injection
    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }


    // 1. Apply Leave
    @PostMapping
    public ResponseEntity<EmployeeLeave> applyLeave(
            @Valid @RequestBody EmployeeLeave leave) {

        EmployeeLeave appliedLeave =
                leaveService.applyLeave(leave);

        return new ResponseEntity<>(
                appliedLeave,
                HttpStatus.CREATED
        );
    }


    // 2. Search Leave by Employee ID
    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getLeaveByEmployeeId(
            @PathVariable int employeeId) {

        EmployeeLeave leave =
                leaveService.getLeaveByEmployeeId(employeeId);

        if (leave != null) {
            return ResponseEntity.ok(leave);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Leave application not found");
    }


    // 3. Update Leave
    @PutMapping("/{employeeId}")
    public ResponseEntity<?> updateLeave(
            @PathVariable int employeeId,
            @Valid @RequestBody EmployeeLeave updatedLeave) {

        EmployeeLeave leave =
                leaveService.updateLeave(
                        employeeId,
                        updatedLeave
                );

        if (leave != null) {
            return ResponseEntity.ok(leave);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Leave application not found");
    }


    // 4. Delete Leave
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteLeave(
            @PathVariable int employeeId) {

        boolean deleted =
                leaveService.deleteLeave(employeeId);

        if (deleted) {
            return ResponseEntity.ok(
                    "Leave application deleted successfully"
            );
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Leave application not found");
    }
}