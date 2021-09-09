package test.tempFilter;

import java.util.List;

public interface TemperatureFilterIF {
    List getPossibleTemperatureCodeList(String intrTemperatureCode, String vehicleTemperatureCode);
}
