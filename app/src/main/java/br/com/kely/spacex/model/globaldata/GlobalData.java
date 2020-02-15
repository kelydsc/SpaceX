package br.com.kely.spacex.model.globaldata;

import java.util.ArrayList;
import java.util.List;


public class GlobalData {

    static private List<String> launchList = new ArrayList<>();

    public GlobalData() {
    }

    public static List<String> getLaunchList() {
        return launchList;
    }

    public static void setLaunchList(List<String> launchList) {
        GlobalData.launchList = launchList;
    }
}
