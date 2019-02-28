package cinema.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class DtoUtils {
	
	public static <T,U> Set<U> setFromEntityStream(
			Stream<T> stream, 
			ModelMapper mapper,
			Class<U> classDto){
		return collectionFromEntityStream(stream, mapper, classDto,HashSet::new);
	}
	
	public static <T,U> NavigableSet<U> navigableSetFromEntityStream(
			Stream<T> stream, 
			ModelMapper mapper,
			Class<U> classDto,
			Comparator<? super U> cmp){
		return collectionFromEntityStream(stream, mapper, classDto,TreeSet::new);
	}
	
	public static <T,U> List<U> listFromEntityStream(
			Stream<T> stream, 
			ModelMapper mapper,
			Class<U> classDto){
		return collectionFromEntityStream(stream, mapper, classDto,ArrayList::new);
	}
	
	public static <T,U, C extends Collection<U>> C collectionFromEntityStream(
			Stream<T> stream, 
			ModelMapper mapper,
			Class<U> classDto,
			Supplier<C> supplier){
		return stream
				.map(e ->  mapper.map(e, classDto))
				.collect(Collectors.toCollection(supplier));
	}

	

}
