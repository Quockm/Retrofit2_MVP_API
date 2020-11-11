package com.example.retrofit2_mvp_api;

import android.app.AlertDialog;
import android.content.Context;

import com.example.retrofit2_mvp_api.Api.FoodApi;
import com.example.retrofit2_mvp_api.Api.FoodClient;

/**
 * Created by QuocKM on 11,November,2020
 * EbizWorld company,
 * HCMCity, VietNam.
 */
public class Utils {
    public static FoodApi getApi() {
        return FoodClient.getFoodClient().create(FoodApi.class);
    }

    public static AlertDialog showDialogMessage(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
        return alertDialog;
    }
}
