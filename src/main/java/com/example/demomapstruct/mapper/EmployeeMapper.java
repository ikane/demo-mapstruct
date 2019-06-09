package com.example.demomapstruct.mapper;

import com.example.demomapstruct.dto.DivisionDTO;
import com.example.demomapstruct.dto.EmployeeDTO;
import com.example.demomapstruct.entity.Division;
import com.example.demomapstruct.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mappings({
            @Mapping(target = "employeeId", source = "employee.id"),
            @Mapping(target = "employeeName", source = "employee.name"),
            @Mapping(target = "employeeStartDt", source = "employee.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss")
            }
    )
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    @Mappings({
            @Mapping(target = "id", source = "employeeDTO.employeeId"),
            @Mapping(target = "name", source = "employeeDTO.employeeName"),
            @Mapping(target = "startDt", source = "employeeDTO.employeeStartDt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    Employee employeeDTOtoEmployee(EmployeeDTO employeeDTO);

    DivisionDTO divisionToDivisionDTO(Division division);

    List<Employee> convertEmployeeDTOListToEmployeeList(List<EmployeeDTO> list);

    List<EmployeeDTO> convertEmployeeListToEmployeeDTOList(List<Employee> list);
}
