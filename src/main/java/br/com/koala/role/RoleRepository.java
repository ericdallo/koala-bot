package br.com.koala.role;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Role.class, idClass = Long.class)
public interface RoleRepository {

	List<Role> findAll();
	
	void save(Role role);

}
