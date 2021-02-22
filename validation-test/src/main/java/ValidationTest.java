import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationTest {

	public static void main(String[] args) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		log.info("Create object state to validate");
		DummyClass dc = new DummyClass();
		dc.value = "Test";
		dc.length = dc.value.length() + 1;

		log.info("Run the object through validation");
		Set<ConstraintViolation<DummyClass>> constraintViolations = validator.validate(dc);

		log.info("Validation result empty: {}", constraintViolations.isEmpty());

		if (log.isDebugEnabled()) {
			for (ConstraintViolation<DummyClass> c : constraintViolations) {
				log.debug("{}:{}", c.getPropertyPath(), c.getMessage());
			}
		}
	}
}
