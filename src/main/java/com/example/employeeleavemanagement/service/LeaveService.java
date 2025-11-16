package com.example.employeeleavemanagement.service;

import com.example.employeeleavemanagement.model.Employee;
import com.example.employeeleavemanagement.model.LeaveRequest;
import com.example.employeeleavemanagement.repository.EmployeeRepository;
import com.example.employeeleavemanagement.repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    private final LeaveRequestRepository leaveRepo;
    private final EmployeeRepository employeeRepo;

    public LeaveService(LeaveRequestRepository leaveRepo, EmployeeRepository employeeRepo) {
        this.leaveRepo = leaveRepo;
        this.employeeRepo = employeeRepo;
    }

    public LeaveRequest applyLeave(Long employeeId, LeaveRequest request) {
        Employee emp = employeeRepo.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        request.setEmployee(emp);
        request.setStatus(LeaveRequest.Status.PENDING);
        return leaveRepo.save(request);
    }

    public List<LeaveRequest> getLeavesForEmployee(Long employeeId) {
        return leaveRepo.findByEmployeeId(employeeId);
    }

    public List<LeaveRequest> getAllLeaves() {
        return leaveRepo.findAll();
    }

    public LeaveRequest updateStatus(Long leaveId, LeaveRequest.Status status) {
        LeaveRequest lr = leaveRepo.findById(leaveId).orElseThrow(() -> new RuntimeException("Leave not found"));
        lr.setStatus(status);
        return leaveRepo.save(lr);
    }
}
