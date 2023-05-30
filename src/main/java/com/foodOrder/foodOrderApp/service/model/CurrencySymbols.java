package com.foodOrder.foodOrderApp.service.model;

import java.util.stream.Stream;

public enum CurrencySymbols {
    USD("usd","$"),
    UNKNOWN("UNKNOWN","UNKNOWN");

    private final String raw;
    private final String symbol;
     CurrencySymbols(String raw,String symbol){
         this.raw = raw;
         this.symbol = symbol;
     }

    public static CurrencySymbols fromRaw(String rawCurrency){
        return Stream.of(values()).filter(v->v.raw.equals(rawCurrency)).findAny().get();
    }
    public String getSymbol(){ return this.symbol;}


}
