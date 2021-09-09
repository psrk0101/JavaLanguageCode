package test.tempFilter.filter.template;

import test.tempFilter.filter.FilterAB;
import test.tempFilter.enm.TemperatureEnum;

import java.util.function.Predicate;

public class AllTypeFilter extends FilterAB {
    protected Predicate<TemperatureEnum> getPredicate() {
        return TemperatureEnum::isPossibleAllTemperature;
    }
}
