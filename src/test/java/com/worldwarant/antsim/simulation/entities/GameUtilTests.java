package com.worldwarant.antsim.simulation.entities;

import com.worldwarant.antsim.common.GameUtils;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameUtilTests {

    @DisplayName("parseEntitiesBySubset is able to parse int sets from properties.")
    @Test
    void testParserParsing() throws ConfigurationException {
        Configuration config = GameUtils.loadProperties("gameConfig.properties");

        Map<String, Integer> workerConfigMap = GameUtils.parseEntitiesBySubset(config, "ants.worker.speedInSeconds", Integer.class);

        assertEquals(workerConfigMap.size(), config.subset("ants.worker.speedInSeconds").size());
        assertEquals(workerConfigMap.get("remains"), config.getInt("ants.worker.speedInSeconds.remains"));
    }

    @DisplayName("parseBySubset is able to parse int sets from properties.")
    @Test
    void testIntegerParserParsing() throws ConfigurationException {
        Configuration config = GameUtils.loadProperties("gameConfig.properties");

        Map<String,Integer> queenConfigMap = GameUtils.parseBySubset(config, "ants.queen.devourSpeedInSeconds");

        assertEquals(queenConfigMap.size(), config.subset("ants.queen.devourSpeedInSeconds").size());
        assertEquals(queenConfigMap.get("min"), config.getInt("ants.queen.devourSpeedInSeconds.min"));
    }

}
