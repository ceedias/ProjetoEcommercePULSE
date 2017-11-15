/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pulse.validadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 *
 * @author cesardias
 */
class ValidaCEPImp implements ConstraintValidator<ValidaCEP, String>{

    @Override
    public void initialize(ValidaCEP constraintAnnotation) {
        
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern p = Pattern.compile("[0-9]{5}-[0-9]{3}");
        Matcher m = p.matcher(value);
        return m.matches();
    }
    
}
