package com.example.demomapstruct.mapper;

import com.example.demomapstruct.dto.SimpleSource;
import com.example.demomapstruct.entity.SimpleDestination;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {

    SimpleDestination sourceToDestination (SimpleSource source);

    SimpleSource destinationToSource (SimpleDestination destination);

}
