package com.example.demomapstruct;

import com.example.demomapstruct.dto.DivisionDTO;
import com.example.demomapstruct.dto.EmployeeDTO;
import com.example.demomapstruct.entity.Division;
import com.example.demomapstruct.entity.Employee;
import com.example.demomapstruct.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMapperTest {

    @Autowired
    EmployeeMapper mapper;

    private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

    @Test
    public void givenEmployeeDTOwithDiffNametoEmployee_whenMaps_thenCorrect() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setEmployeeId(1);
        dto.setEmployeeName("John");

        Employee entity = mapper.employeeDTOtoEmployee(dto);

        assertThat(dto.getEmployeeId()).isEqualTo(entity.getId());
        assertThat(dto.getEmployeeName()).isEqualTo(entity.getName());
    }

    @Test
    public void givenEmployeewithDiffNametoEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setId(1);
        entity.setName("John");

        EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);

        assertThat(dto.getEmployeeId()).isEqualTo(entity.getId());
        assertThat(dto.getEmployeeName()).isEqualTo(entity.getName());
    }

    @Test
    public void givenEmployeeDTOwithNestedMappingToEmployee_whenMaps_thenCorrect() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setDivision(new DivisionDTO(1, "Division1"));

        Employee entity = mapper.employeeDTOtoEmployee(dto);

        assertThat(dto.getDivision().getId()).isEqualTo(entity.getDivision().getId());
        assertThat(dto.getDivision().getName()).isEqualTo(entity.getDivision().getName());
    }

    @Test
    public void givenEmployeeWithNestedMappingToEmployeeDTO_whenMaps_thenCorrect() {
        Employee entity = new Employee();
        entity.setDivision(new Division(1, "Division1"));

        EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);

        assertThat(dto.getDivision().getId()).isEqualTo(entity.getDivision().getId());
        assertThat(dto.getDivision().getName()).isEqualTo(entity.getDivision().getName());
    }

    @Test
    public void givenEmployeeListToEmployeeDTOList_whenMaps_thenCorrect() {
        List<Employee> employeeList = new ArrayList<>();
        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("EmpName");
        emp.setDivision(new Division(1, "Division1"));
        employeeList.add(emp);

        List<EmployeeDTO> employeeDtoList = mapper.convertEmployeeListToEmployeeDTOList(employeeList);
        EmployeeDTO employeeDTO = employeeDtoList.get(0);
        assertThat(employeeDTO.getEmployeeId()).isEqualTo(emp.getId());
        assertThat(employeeDTO.getEmployeeName()).isEqualTo(emp.getName());
        assertThat(employeeDTO.getDivision().getId()).isEqualTo(emp.getDivision().getId());
        assertThat(employeeDTO.getDivision().getName()).isEqualTo(emp.getDivision().getName());
    }

    @Test
    public void givenEmployeeDTOListToEmployeeList_whenMaps_thenCorrect() {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        EmployeeDTO empDTO = new EmployeeDTO();
        empDTO.setEmployeeId(1);
        empDTO.setEmployeeName("EmpName");
        empDTO.setDivision(new DivisionDTO(1, "Division1"));
        employeeDTOList.add(empDTO);

        List<Employee> employeeList = mapper.convertEmployeeDTOListToEmployeeList(employeeDTOList);
        Employee employee = employeeList.get(0);
        assertThat(employee.getId()).isEqualTo(empDTO.getEmployeeId());
        assertThat(employee.getName()).isEqualTo(empDTO.getEmployeeName());
        assertThat(employee.getDivision().getId()).isEqualTo(empDTO.getDivision().getId());
        assertThat(employee.getDivision().getName()).isEqualTo(empDTO.getDivision().getName());
    }

    @Test
    public void givenEmployeeWithStartDateMappingToEmployeeDTO_whenMaps_thenCorrect() throws ParseException {
        Employee entity = new Employee();
        entity.setStartDt(new Date());

        EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);

        assertThat(format.parse(dto.getEmployeeStartDt()).toString()).isEqualTo(entity.getStartDt().toString());
    }

}
