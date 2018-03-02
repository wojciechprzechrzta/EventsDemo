package com.przechu.eventsdemo.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

@Profile("generic")
@AllArgsConstructor
@Getter
public class AgentEvent<T extends EventTypes> implements ResolvableTypeProvider {
    private T source;

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(getClass(),
                ResolvableType.forInstance(source));
    }
}
