package com.employee.employee_leave_management.service;

import com.employee.employee_leave_management.model.EmployeeLeave;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaveService {

    // In-memory storage instead of database
    private final List<EmployeeLeave> leaveList = new ArrayList<>();


    // 1. Apply Leave
    public EmployeeLeave applyLeave(EmployeeLeave leave) {

        leaveList.add(leave);

        return leave;
    }


    // 2. Search Leave by Employee ID
    public EmployeeLeave getLeaveByEmployeeId(int employeeId) {

        for (EmployeeLeave leave : leaveList) {

            if (leave.getEmployeeId() == employeeId) {
                return leave;
            }
        }

        return null;
    }


    // 3. Update Leave
    public EmployeeLeave updateLeave(
            int employeeId,
            EmployeeLeave updatedLeave) {

        EmployeeLeave existingLeave =
                getLeaveByEmployeeId(employeeId);

        if (existingLeave != null) {

            existingLeave.setEmployeeName(
                    updatedLeave.getEmployeeName());

            existingLeave.setLeaveType(
                    updatedLeave.getLeaveType());

            existingLeave.setNumberOfDays(
                    updatedLeave.getNumberOfDays());

            existingLeave.setReason(
                    updatedLeave.getReason());

            return existingLeave;
        }

        return null;
    }


    // 4. Delete Leave
    public boolean deleteLeave(int employeeId) {

        EmployeeLeave leave =
                getLeaveByEmployeeId(employeeId);

        if (leave != null) {

            leaveList.remove(leave);

            return true;
        }

        return false;
    }
}