package pl.pw.vhacks.interfaith_parent_connection.entities;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.Id;

@Data
@SolrDocument(solrCoreName = "core")
public class SolrPost {

    @Id
    private Long id;

    @Field("topic")
    private String topic;

    @Field("text")
    private String text;
}
