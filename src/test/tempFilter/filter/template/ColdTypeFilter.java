package test.tempFilter.filter.template;

import test.tempFilter.enm.TemperatureEnum;
import test.tempFilter.filter.FilterAB;

import java.util.function.Predicate;

public class ColdTypeFilter extends FilterAB {
    @Override
    protected Predicate<TemperatureEnum> getPredicate() {
        return TemperatureEnum::isPossibleColdTemperature;
    }
}
