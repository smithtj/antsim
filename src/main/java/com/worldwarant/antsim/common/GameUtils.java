package com.worldwarant.antsim.common;

import com.worldwarant.antsim.Program;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.ImmutableConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.util.HashMap;
import java.util.Map;


public class GameUtils {
    private GameUtils(){}

    public static Configuration loadProperties(String propertiesFileName) throws ConfigurationException {
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(propertiesFileName));
        Configuration config = builder.getConfiguration();
        return config;

    }

    public static <T> Map<String, T> parseEntitiesBySubset(final Configuration config, final String subsetKey, final Class<T> genericType) {
        ImmutableConfiguration configSubset = config.immutableSubset(subsetKey);
        Map<String, T> subsetMap = new HashMap<>();
        configSubset.getKeys().forEachRemaining(key -> subsetMap.put(key, configSubset.get(genericType, key)));
        return subsetMap;
    }

    public static Map<String, Integer> parseBySubset(final Configuration config, final String subsetKey) {
        return parseEntitiesBySubset(config, subsetKey, Integer.class);
    }
}
