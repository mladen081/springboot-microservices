package u.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import u.departmentservice.dto.DepartmentDto;
import u.departmentservice.entity.Department;

@Mapper
public interface AutoDepartmentMapper {

    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    DepartmentDto mapToDepartmentDto(Department employee);

    Department mapToDepartment(DepartmentDto employeeDto);
}
