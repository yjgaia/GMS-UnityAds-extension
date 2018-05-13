#import "UnityAds/UnityAds.h"
#import "UnityAdsExt.h"

@implementation UnityAdsExt

const int EVENT_OTHER_SOCIAL = 70;
extern int CreateDsMap( int _num, ... );
extern void CreateAsynEventWithDSMap(int dsmapindex, int event_index);

- (double) unity_ads_init:(char *)game_id Arg2:(double)is_test_mode
{
    // Initialize Unity Ads
    [UnityAds initialize:[NSString stringWithUTF8String:game_id] delegate:self testMode:is_test_mode];

    return (double)-1;
}

- (double) unity_ads_check_is_can_show
{
    if ([UnityAds isReady:@"rewardedVideo"]) {
        return (double)1;
    } else {
        return (double)0;
    }
    return (double)-1;
}

- (double) unity_ads_show
{
    if ([UnityAds isReady:@"rewardedVideo"]) {
        
        UIViewController * activeController = [UIApplication sharedApplication].keyWindow.rootViewController;
        if ([activeController isKindOfClass:[UINavigationController class]]) {
            activeController = [(UINavigationController *) activeController visibleViewController];
        }

        [UnityAds show:activeController placementId:@"rewardedVideo"];
    }
    return (double)-1;
}

- (void)unityAdsReady:(NSString *)placementId{
}

- (void)unityAdsDidError:(UnityAdsError)error withMessage:(NSString *)message{
}

- (void)unityAdsDidStart:(NSString *)placementId{
}

- (void)unityAdsDidFinish:(NSString *)placementId withFinishState:(UnityAdsFinishState)state{
    if (state == kUnityAdsFinishStateCompleted) {
        CreateAsynEventWithDSMap(CreateDsMap(1,
             "type", 0.0, "unity_ads_video_completed", (void *)NULL
             ), EVENT_OTHER_SOCIAL);
    }
}

@end