package br.com.kely.spacex.model.globaldata;

import br.com.kely.spacex.model.api.Launch;

public class GlobalData {

    private static Launch launch;

    public GlobalData() {
    }

    public static Launch getLaunch() {
        return launch;
    }

    public static void setLaunch(Launch launch) {
        GlobalData.launch = launch;
    }
}
