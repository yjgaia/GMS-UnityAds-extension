package ${YYAndroidPackageName};

import com.unity3d.ads.IUnityAdsListener;

import com.yoyogames.runner.RunnerJNILib;

public class UnityAds implements IUnityAdsListener {
	
	private static final int EVENT_OTHER_SOCIAL = 70;

	public double unity_ads_init(final String game_id, final double is_test_mode) {
		RunnerActivity.ViewHandler.post(new Runnable() {
			public void run() {
				if (is_test_mode == 1) {
					com.unity3d.ads.UnityAds.initialize(RunnerActivity.CurrentActivity, game_id, (IUnityAdsListener) UnityAds.this, true);
				} else {
					com.unity3d.ads.UnityAds.initialize(RunnerActivity.CurrentActivity, game_id, (IUnityAdsListener) UnityAds.this, false);
				}
			}
		});
		return -1;
	}

	public double unity_ads_check_is_can_show() {
		if (com.unity3d.ads.UnityAds.isReady() == true) {
			return 1;
		} else {
			return 0;
		}
	}

	public double unity_ads_show() {
		RunnerActivity.ViewHandler.post(new Runnable() {
			public void run() {
				if (com.unity3d.ads.UnityAds.isReady() == true) {
					com.unity3d.ads.UnityAds.show(RunnerActivity.CurrentActivity, "rewardedVideo");
				}
			}
		});
		return -1;
	}

	@Override
	public void onUnityAdsFinish(String s, com.unity3d.ads.UnityAds.FinishState finishState) {
		int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
		RunnerJNILib.DsMapAddString(dsMapIndex, "type", "unity_ads_video_completed");
		RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex, EVENT_OTHER_SOCIAL);
	}

    @Override
    public void onUnityAdsReady(String s) {}

    @Override
    public void onUnityAdsStart(String s) {}

    @Override
    public void onUnityAdsError(com.unity3d.ads.UnityAds.UnityAdsError unityAdsError, String s) {}
}
