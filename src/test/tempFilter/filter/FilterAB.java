package test.tempFilter.filter;

import test.tempFilter.enm.TemperatureEnum;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class FilterAB implements FilterIF{
    @Override
    public List getFilterCode(String vehicleTemperature) {
        Predicate<TemperatureEnum> p = getPredicate();
        return getTemperatureCode(p);
    }

    protected abstract Predicate<TemperatureEnum> getPredicate();

    private boolean checkPossibleTemperature(Predicate<TemperatureEnum> p, String vehicleTemperature){
        return Arrays.stream(TemperatureEnum.values()).filter(p).anyMatch(entity -> entity.getCode().equals(vehicleTemperature));
    }

    private List getTemperatureCode(Predicate<TemperatureEnum> p){
        return Arrays.stream(TemperatureEnum.values()).filter(p).map(m -> m.getCode()).collect(Collectors.toList());
    }
}
