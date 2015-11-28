package com.androiddevclass.thirstbuster;

import java.util.Date;

/**
 * Created by Shawn on 11/27/2015.
 */
public class WaterTotals {

    private int _id;
    private String _cupsTotal;
    private String _ouncesTotal;
    private String _date;

    public WaterTotals(){}

    public WaterTotals(String ouncesTotal, String cupsTotal) {
        this._ouncesTotal = ouncesTotal;
        this._cupsTotal = cupsTotal;
    }

    public String get_ouncesTotal() {
        return _ouncesTotal;
    }

    public void set_ouncesTotal(String _ouncesTotal) {
        this._ouncesTotal = _ouncesTotal;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_cupsTotal() {
        return _cupsTotal;
    }

    public void set_cupsTotal(String _cupsTotal) {
        this._cupsTotal = _cupsTotal;
    }
}
