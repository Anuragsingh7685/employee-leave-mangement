package com.example.employeeleavemanagement.controller;

import com.example.employeeleavemanagement.model.LeaveRequest;
import com.example.employeeleavemanagement.service.LeaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    private final LeaveService leaveService;
    public LeaveController(LeaveService leaveService) { this.leaveService = leaveService; }

    @PostMapping("/apply/{employeeId}")
    public ResponseEntity<LeaveRequest> applyLeave(@PathVariable Long employeeId, @RequestBody LeaveRequest request) {
        LeaveRequest saved = leaveService.applyLeave(employeeId, request);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<LeaveRequest>> getForEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(leaveService.getLeavesForEmployee(employeeId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<LeaveRequest>> getAll() {
        return ResponseEntity.ok(leaveService.getAllLeaves());
    }

    @PutMapping("/{leaveId}/status")
    public ResponseEntity<LeaveRequest> updateStatus(@PathVariable Long leaveId, @RequestParam LeaveRequest.Status status) {
        return ResponseEntity.ok(leaveService.updateStatus(leaveId, status));
    }
}
