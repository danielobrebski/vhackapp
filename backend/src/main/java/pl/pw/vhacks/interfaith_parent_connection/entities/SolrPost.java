package pl.pw.vhacks.interfaith_parent_connection.entities;

import lombok.Data;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.Id;

@Data
@SolrDocument(solrCoreName = "core")
public class SolrPost {

    @Id
    private Long id;

    @Indexed(name = "topic", type = "string")
    private String topic;
}
