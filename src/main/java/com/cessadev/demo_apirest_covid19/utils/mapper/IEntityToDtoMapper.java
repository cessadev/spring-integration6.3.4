package com.cessadev.demo_apirest_covid19.utils.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface IEntityToDtoMapper<E, D> {

    D toDto(E entity);

    default List<D> toDtoList(List<E> entities) {
        if (entities == null || entities.isEmpty()) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
