package com.example.liuwangshu.moondatabinding.util;

import android.databinding.BindingConversion;

import com.example.liuwangshu.moondatabinding.model.Swordsman;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Utils {
    public static String getName(Swordsman swordsman) {
        return swordsman.getName();
    }

    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
