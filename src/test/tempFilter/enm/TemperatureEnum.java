package test.tempFilter.enm;

public enum TemperatureEnum {
    ORDINARY_TEMPERATURE("10", "OrdinaryTypeFilter", true, false, false, false,false)
    ,COLD_TEMPERATURE("20", "ColdTypeFilter", false, true, false, false, false)
    ,FREEZE_TEMPERATURE("30", "FreezeTypeFilter", false, false, true, false, false)
    ,COLD_FREEZE_TEMPERATURE("40", "ColdFreezeTypeFilter", false, true, true, true, false)
    ,ALL_TEMPERATURE("60", "AllTypeFilter", true, true, true, true, true)
    ;

    private String code;
    private String filterName;
    private boolean isPossibleOrdinary;
    private boolean isPossibleCold;
    private boolean isPossibleFreeze;
    private boolean isColdPossibleFreeze;
    private boolean isPossibleAll;

    TemperatureEnum(String code, String filterName, boolean isPossibleOrdinary, boolean isPossibleCold, boolean isPossibleFreeze, boolean isPossibleColdFreeze, boolean isPossibleAll) {
        this.code = code;
        this.filterName = filterName;
        this.isPossibleOrdinary = isPossibleOrdinary;
        this.isPossibleCold = isPossibleCold;
        this.isPossibleFreeze = isPossibleFreeze;
        this.isColdPossibleFreeze = isPossibleColdFreeze;
        this.isPossibleAll = isPossibleAll;
    }

    public String getCode(){
        return code;
    }

    public String getFilterName(){
        return filterName;
    }

    public boolean isPossibleOrdinaryTemperature(){
        return isPossibleOrdinary;
    }

    public boolean isPossibleColdTemperature(){
        return isPossibleCold;
    }

    public boolean isPossibleFreezeTemperature(){
        return isPossibleFreeze;
    }

    public boolean isPossibleColdFreezeTemperature(){
        return isColdPossibleFreeze;
    }

    public boolean isPossibleAllTemperature(){
        return isPossibleAll;
    }

}
