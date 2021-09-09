package test.tempFilter;

import test.tempFilter.filter.FilterIF;
import test.tempFilter.filter.FilterFactory;

import java.util.List;

public class TemperatureFilter implements TemperatureFilterIF {
    private FilterIF filter;

    private void setFilter(String itnrTemperatureCode){
        filter = new FilterFactory().getTemperatureFilter(itnrTemperatureCode);
    }

    public List getPossibleTemperatureCodeList(String intrTemperatureCode, String vehicleTemperatureCode) {
        setFilter(intrTemperatureCode);
        return filter.getFilterCode(vehicleTemperatureCode);
    }
}
