// essa inteface faz a conexão com o banco, todas as operações
// estão embutidas no mongoRepository

package com.rodrigonunes.springbootmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rodrigonunes.springbootmongo.domain.Post;


/*
 * MongoRepository<T, Serializable> = T é o tipo da classe que ele
 * vai gerenciar
 * Serializable = é onde definimos o tipo de id da classe
 * */
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	/*
	 * Consulta personalida com @Query
	 * O jeito que escrevemos a consulta é padrão do próprio mongo
	 * ?0 = indica o primeiro parametro que o método recebe, nesse caso o text
	 * */
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	/*
	 * Aqui é um query methods, ele vai procurar 
	 * automaticamente um post que o campo
	 * title seja igual a string
	 * */
	List<Post> findByTitleContainingIgnoreCase(String text);
}
