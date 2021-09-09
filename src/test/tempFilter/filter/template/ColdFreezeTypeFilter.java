package test.tempFilter.filter.template;

import test.tempFilter.enm.TemperatureEnum;
import test.tempFilter.filter.FilterAB;

import java.util.function.Predicate;

public class ColdFreezeTypeFilter extends FilterAB {
    @Override
    protected Predicate<TemperatureEnum> getPredicate() {
        return TemperatureEnum::isPossibleColdFreezeTemperature;
    }
}
