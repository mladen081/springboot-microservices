package u.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import u.employeeservice.dto.EmployeeDto;
import u.employeeservice.entity.Employee;

@Mapper
public interface AutoEmployeeMapper {

    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);
}
