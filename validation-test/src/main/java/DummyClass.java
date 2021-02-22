import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@DummyClassState
public class DummyClass {
	@NotNull
	public String value;
	@Min(1000)
	public int length;

	Map<?,?> mapOfElements = new HashMap<>();
}
