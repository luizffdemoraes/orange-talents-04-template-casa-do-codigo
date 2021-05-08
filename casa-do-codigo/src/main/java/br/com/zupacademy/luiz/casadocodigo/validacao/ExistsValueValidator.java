package br.com.zupacademy.luiz.casadocodigo.validacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;


public class ExistsValueValidator implements ConstraintValidator<ExistsValue, Object> {

    private String targetAttribute;
    private Class<?> klass;
    private boolean shoudExist;

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistsValue params) { 
        targetAttribute = params.fieldName();
        klass = params.targetClass();
    }


    @Override // CI: 1
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        // 1
        Query query = manager.createQuery("select 1 from "+klass.getName()+ " where "+ targetAttribute+"=:pValue");
        query.setParameter("pValue", value);
        List<?> list = query.getResultList();

        return !list.isEmpty();


    }
}