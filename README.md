# UnityAds-extension
게임메이커 스튜디오 용 유니티 광고 익스텐션 소스 코드 및 샘플입니다. Android와 iOS 환경에서 실행 가능합니다.

## 환경 설정
https://dashboard.unityads.unity3d.com 에 접속하여, `Integration Id`가 `rewardedVideo`인 Ad placement를 생성합니다.

## 함수
* `unity_ads_init(game_id, is_test_mode)` Unity Ads를 초기화합니다. 테스트 모드로 실행하려면 `is_test_mode`를 `true`로 설정합니다. 출시 할 때는 `false`로 설정합니다.
* `unity_ads_check_is_can_show()` Unity Ads가 현재 사용 가능한지 확인합니다.
* `unity_ads_show()` 광고를 출력합니다.

## 예제 코드
* [Unity Ads 초기화](https://gist.github.com/Hanul/20c0ae084b23ffb58035cc0970d21d1e)
* [광고! 광고를 보자!](https://gist.github.com/Hanul/64f992a52c8eeccdd79f08e043133b92)
* [다 봤다면 이벤트를 받아오자!](https://gist.github.com/Hanul/728c0c8a201b3c371ec64c4de920be15)

## iOS용 애플리케이션 빌드 시 주의사항
게임메이커 스튜디오의 버그로 인해, iOS용 애플리케이션을 빌드 할 때에 오류가 발생합니다. 따라서 SDK를 직접 다운로드하여 넣어야 합니다.

아래 경로에서 SDK를 다운로드하여 `UnityAds.framework`를 넣습니다.

https://github.com/Unity-Technologies/unity-ads-ios/releases

iOS용 애플리케이션의 경우, 광고를 볼 때 터치 이벤트가 광고 화면을 뚫으니, 터치 이벤트를 방지할 오브젝트를 만들고 `unity_ads_video_completed` 이벤트 발생시 그 오브젝트를 지우면 됩니다.

## 라이센스
[MIT](LICENSE)

## 작성자
[Young Jae Sim](https://github.com/Hanul)