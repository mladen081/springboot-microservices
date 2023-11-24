package u.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import u.departmentservice.dto.DepartmentDto;
import u.departmentservice.entity.Department;
import u.departmentservice.exceptions.ResourceNotFoundException;
import u.departmentservice.mapper.AutoDepartmentMapper;
import u.departmentservice.repository.DepartmentRepository;
import u.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

//    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department dto to department jpa entity

        Department department = AutoDepartmentMapper.MAPPER.mapToDepartment(departmentDto);

        Department savedDepartment =  departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                () -> new ResourceNotFoundException("Department", "id", departmentCode)
        );

        DepartmentDto departmentDto = AutoDepartmentMapper.MAPPER.mapToDepartmentDto(department);

        return departmentDto;
    }
}
