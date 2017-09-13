package br.com.koala.kaos;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = KaosGif.class, idClass = Long.class)
public interface KaosGifRepository {

	List<KaosGif> findAll();

}
