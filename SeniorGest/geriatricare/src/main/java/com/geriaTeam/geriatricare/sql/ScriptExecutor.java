package com.geriaTeam.geriatricare.sql;

import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class ScriptExecutor {

    private final DataSource dataSource;

    public ScriptExecutor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void executarScriptsSQL() {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try (Connection conn = dataSource.getConnection()) {
            Resource[] resources = resolver.getResources("classpath:scripts/*.sql");

            // Opcional: ordenar scripts para garantir ordem de execução
            java.util.Arrays.sort(resources, (r1, r2) -> r1.getFilename().compareTo(r2.getFilename()));

            for (Resource resource : resources) {
                System.out.println("Executando script: " + resource.getFilename());
                ScriptUtils.executeSqlScript(conn, resource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
