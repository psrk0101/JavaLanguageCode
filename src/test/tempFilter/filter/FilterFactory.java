package test.tempFilter.filter;

import test.tempFilter.enm.TemperatureEnum;
import test.tempFilter.filter.template.DefaultTypeFilter;

import java.lang.reflect.Constructor;

public class FilterFactory {
    private final String FILTER_OBJ_PACKAGE_PATH = "test.tempFilter.filter.template.";

    public FilterIF getTemperatureFilter(String code)
    {
        String filterName = getFilterName(code);
        return getFilter(filterName);
    }

    private String getFilterName(String code){
        String filterName = null;
        for (TemperatureEnum temperatureEnum : TemperatureEnum.values()) {
            if(temperatureEnum.getCode().equals(code)){
                filterName = temperatureEnum.getFilterName();
                break;
            }
        }
        return filterName;
    }

    private FilterIF getFilter(String code){
        FilterIF filter = new DefaultTypeFilter();
        if(code != null){
            try {
                Class<?> filterClass = Class.forName(FILTER_OBJ_PACKAGE_PATH + code);
                Constructor<?> filterClassConstructor = filterClass.getConstructor();
                filter = (FilterIF) filterClassConstructor.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return filter;
    }
}
