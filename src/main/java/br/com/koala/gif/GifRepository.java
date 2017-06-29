package br.com.koala.gif;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Gif.class, idClass = Long.class)
public interface GifRepository {

	List<Gif> findAll();
}
