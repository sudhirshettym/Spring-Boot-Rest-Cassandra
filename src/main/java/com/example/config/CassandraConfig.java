package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;

import java.util.Arrays;
import java.util.List;

public class CassandraConfig extends AbstractCassandraConfiguration {

    private static final String KEYSPACE = "emp";
    private static final String ENTITY_BASE_PACKAGE = "com.example.domain";

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(KEYSPACE));
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {ENTITY_BASE_PACKAGE};
    }

    //can externalize contact point and port
    @Bean
    @Override
    public CassandraClusterFactoryBean cluster() {
        CassandraClusterFactoryBean clusterFactoryBean = new CassandraClusterFactoryBean();
        clusterFactoryBean.setContactPoints("192.168.43.91");
        clusterFactoryBean.setPort(9042);
        return clusterFactoryBean;
    }
}
