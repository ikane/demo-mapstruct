package com.example.demomapstruct;


import com.example.demomapstruct.dto.SimpleSource;
import com.example.demomapstruct.entity.SimpleDestination;
import com.example.demomapstruct.mapper.SimpleSourceDestinationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleSourceDestinationMapperIntegrationTest {

    @Autowired
    SimpleSourceDestinationMapper simpleSourceDestinationMapper;

    @Test
    public void givenSimpleSourceToSimpleDestination_whenMaps_thenCorrect() {
        SimpleSource simpleSource = SimpleSource.builder()
                .name("SourceName")
                .description("SourceDescription")
                .build();

        SimpleDestination destination = this.simpleSourceDestinationMapper.sourceToDestination(simpleSource);

        assertThat(destination.getName()).isEqualTo(simpleSource.getName());
        assertThat(destination.getDescription()).isEqualTo(simpleSource.getDescription());

    }

}
