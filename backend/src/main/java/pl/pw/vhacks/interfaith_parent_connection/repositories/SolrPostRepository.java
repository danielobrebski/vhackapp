package pl.pw.vhacks.interfaith_parent_connection.repositories;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;
import pl.pw.vhacks.interfaith_parent_connection.dtos.PostDto;

import java.util.List;

@Repository
public interface SolrPostRepository extends SolrCrudRepository<PostDto, String> {
    List<PostDto> findByTextOrByTopic(String text);
    List<PostDto> findByText(String text);
}
