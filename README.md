# AutoLog · B05 / B06

11/15 AutoLog Mock 시연용 기록 생성과 회귀 검증 작업입니다. 입력과 출력은 B01 v0.2 계약과 [B04 Fixture](https://github.com/Mybread2/pleos-care-log/tree/1e779a6eb2f121064e28cfd9824d5aff24b079a4/mock-fixtures)를 기준으로 합니다.

## B05 · 기록 생성

- ICE 시동과 EV READY 이벤트를 처리해 주행 구간(Leg), 여정(Journey), 주유·충전 후보를 생성합니다.
- 대표 ICE 시나리오는 Leg 2건, Journey 1건, 활성 운행 35분, 12km, 주유 후보 1건입니다. 수량과 금액은 사용자 입력 전까지 미확인으로 표시합니다.
- 원본 차량 이벤트와 사용자 금액 정정 이력을 보존합니다. 같은 Mock 이벤트를 다시 처리할 때 저장된 정정을 적용합니다.
- F04는 08:10~08:20의 600초를 관측 공백으로 남깁니다. Mock 기준으로 Leg 1건, 활성 운행 1,200초, 관측된 누적계 차분 13km입니다.

## B06 · 검증 결과

| 검증 | 결과 |
| --- | --- |
| 원본 Android 프로젝트 Gradle 단위 테스트 | 77건 통과, 실패 0건 |
| B04 Fixture 검산 | F01~F06 6건 통과 |
| Android 디버그 APK | 빌드 성공 |
| Android Automotive API 34 Mock 화면 | 65,000원 저장 후 상세 재진입 및 앱 재실행에서 값 유지. 67,000원으로 수정 후 상세 재진입에서 수정값 유지 |

이 브랜치에는 B05 Kotlin 엔진, B06 회귀 테스트 13건, 테스트에 필요한 B04 Fixture와 Gradle 구성이 포함되어 있습니다. JDK 17로 실행합니다.

```powershell
.\gradlew.bat test
```

화면 검증은 Kotlin B05 엔진을 연결한 Android 디버그용 Mock 화면에서 수행했습니다. 팀의 [F03 웹 시연](https://github.com/Mybread2/pleos-care-log/tree/08e384408c1055c1a9f7f5baad28506409dcd789/frontend)은 자체 JavaScript 엔진으로 같은 B04 Fixture를 검증합니다. Pleos 전용 에뮬레이터와 실차 SDK 연결은 미검증입니다.
