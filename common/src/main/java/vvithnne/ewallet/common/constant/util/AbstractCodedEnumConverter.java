package vvithnne.ewallet.common.constant.util;

import jakarta.persistence.AttributeConverter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class AbstractCodedEnumConverter<T extends Enum<T> & CodedEnum<E>, E> implements AttributeConverter<T, E> {

    private final Class<T> clazz;

    @Override
    public T convertToEntityAttribute(E data) {
        if (Objects.isNull(data)) {
            return null;
        }
        return Arrays.stream(clazz.getEnumConstants())
                .filter(e -> e.getCode().equals(data))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown code: " + data));
    }

}
