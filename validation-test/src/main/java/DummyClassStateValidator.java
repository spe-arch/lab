import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DummyClassStateValidator implements ConstraintValidator<DummyClassState, DummyClass> {

	public boolean isValid(DummyClass value, ConstraintValidatorContext context) {
		boolean valid = true;

		if (value.value.length() != value.length) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("length is wrong!")
					.addPropertyNode("length")
					.addConstraintViolation();
			valid = false;
		}

		if (!value.mapOfElements.containsKey("guid"))  {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("no guid value set")
					.addPropertyNode("mapOfKeys")
					.addConstraintViolation();
			valid = false;
		}

		return valid;
	}
}
