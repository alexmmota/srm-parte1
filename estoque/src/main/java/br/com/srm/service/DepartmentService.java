package br.com.srm.service;

import br.com.srm.exception.BusinessServiceException;
import br.com.srm.model.DepartmentEntity;
import br.com.srm.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private static Logger logger = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public DepartmentEntity save(DepartmentEntity department) {
        logger.info("m=save, department={}", department);
        if (department.isNew() && departmentRepository.findByName(department.getName()) != null)
            throw new BusinessServiceException("Ja existe um departamento com esse nome");
        return departmentRepository.save(department);
    }

    public List<DepartmentEntity> findByName(String name) {
        logger.info("m=findByName, name={}", name);
        return departmentRepository.findByNameContainingIgnoreCase(name);
    }

    public void delete(Long id) {
        logger.info("m=delete, id={}", id);
        departmentRepository.deleteById(id);
    }

    public DepartmentEntity findById(Long id) {
        logger.info("m=findById, id={}", id);
        Optional<DepartmentEntity> optional = departmentRepository.findById(id);
        if (optional.isPresent())
            return optional.get();
        return null;
    }

}
