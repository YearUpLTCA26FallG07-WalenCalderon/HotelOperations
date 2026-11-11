package com.pluralsight;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee {

    private long employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private LocalDateTime startTime;
    private boolean clockedIn;

    public Employee(long employeeId, String name,
                    String department, double payRate,
                    double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public void punchIn(int time) {
        if (!clockedIn) {
            startTime = LocalDate.now().atTime(time, 0);
            clockedIn = true;
        }
    }

    public void punchIn() {
        if (!clockedIn) {
            startTime = LocalDateTime.now();
            clockedIn = true;
        }
    }
    public void punchOut(int time) {
        if (clockedIn) {
            LocalDateTime endTime = LocalDate.now().atTime(time, 0);

            if (endTime.isBefore(startTime)) {
                System.out.println("Invalid punch out time.");
                return;
            }

            Duration worked = Duration.between(startTime, endTime);

            hoursWorked += worked.toMillis() / 3_600_000.0;
            clockedIn = false;
        } else {
            System.out.println("Employee is not clocked in.");
        }
    }
    public void punchOut(){
        if (clockedIn) {
            LocalDateTime endTime = LocalDateTime.now();

            if (endTime.isBefore(startTime)) {
                System.out.println("Invalid punch out time.");
                return;
            }

            Duration worked = Duration.between(startTime, endTime);

            hoursWorked += worked.toMillis() / 3_600_000.0;
            clockedIn = false;
        } else {
            System.out.println("Employee is not clocked in.");
        }
    }

    public void punchTimeCard(int time) {
        if (clockedIn) {
            punchOut(time);
        } else {
            punchIn(time);
        }
    }

    public double getRegularHours() {
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours() {
        return Math.max(hoursWorked - 40, 0);
    }

    public double getTotalPay() {
        return (getRegularHours() * payRate)
                + (getOvertimeHours() * payRate * 1.5);
    }
}
