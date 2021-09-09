package test.tempFilter.filter.template;

import test.tempFilter.filter.FilterAB;
import test.tempFilter.enm.TemperatureEnum;

import java.util.function.Predicate;

public class DefaultTypeFilter extends FilterAB {
    @Override
    protected Predicate<TemperatureEnum> getPredicate() {
        return x -> false;
    }
}
