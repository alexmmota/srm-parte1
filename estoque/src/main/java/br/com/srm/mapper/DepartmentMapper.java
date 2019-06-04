package br.com.srm.mapper;

import br.com.srm.dto.request.DepartmentRequest;
import br.com.srm.dto.request.ProductRequest;
import br.com.srm.dto.response.DepartmentResponse;
import br.com.srm.dto.response.ProductResponse;
import br.com.srm.model.DepartmentEntity;
import br.com.srm.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(source = "changeDate", dateFormat = "dd/MM/yyyy hh:mm:ss", target = "changeDate")
    DepartmentResponse departmentEntityToDepartmentResponse(DepartmentEntity departmentEntity);

    DepartmentEntity departmentRequestToDepartmentEntity(DepartmentRequest departmentRequest);

}
