package br.com.apirest.compostagem.validacaoCpf;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CpfValidador.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Cpf {

    String message() default "invalid.document";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
