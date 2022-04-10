package memories.models;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MemoryTest {

    @Test
    void shouldFailValidation(){
        Memory memory = new Memory();

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator(); // Returns a Hibernate validator hidden behind an interface.
        Set<ConstraintViolation<Memory>> violations = validator.validate(memory);
        assertEquals(4, violations.size());
    }


}