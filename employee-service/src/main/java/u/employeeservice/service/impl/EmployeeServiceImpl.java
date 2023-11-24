package u.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import u.employeeservice.dto.EmployeeDto;
import u.employeeservice.entity.Employee;
import u.employeeservice.exceptions.EmailAlreadyExistsException;
import u.employeeservice.exceptions.ResourceNotFoundException;
import u.employeeservice.mapper.AutoEmployeeMapper;
import u.employeeservice.repository.EmployeeRepository;
import u.employeeservice.service.EmployeeService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Optional<Employee> optionalEmployee = employeeRepository.findByEmail(employeeDto.getEmail());

        if(optionalEmployee.isPresent()) {
            throw new EmailAlreadyExistsException("Email Already Exists for a Employee");
        }

        Employee employee = AutoEmployeeMapper.MAPPER.mapToEmployee(employeeDto);

        Employee savedEmployee =  employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapToEmployeeDto(employee);

        return employeeDto;
    }
}
