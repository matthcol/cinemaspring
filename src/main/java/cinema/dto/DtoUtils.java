package cinema.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DtoUtils {
	public static <T,U> Set<T> setFromEntityStream(Stream<U> stream, Function<? super U,? extends T> adapter){
		return stream
				.map(adapter)
				.collect(Collectors.toCollection(HashSet::new));
	}
	
	public static <T,U> T dtoFromEntity (U u, Function<? super U,? extends T> adapter) {
		return adapter.apply(u);
	}
}
