# AutoLog · B05

B01 v0.2의 Mock 이벤트를 처리하는 Kotlin 기록 엔진입니다. ICE 시동과 EV READY를 기준으로 Leg를 만들고, Journey와 주유·충전 후보를 반환합니다. 원본 이벤트와 사용자가 정정한 금액은 따로 보존합니다.

대표 ICE 시나리오의 출력은 Leg 2건, Journey 1건, 활성 운행 35분, 12km, 주유 후보 1건입니다. F04의 600초 관측 공백은 활성 운행시간에서 제외합니다. 양 끝의 누적 주행거리 차분은 13km입니다.

JDK 17 이상에서 엔진을 빌드할 수 있습니다.

```powershell
.\gradlew.bat assemble
```

회귀 테스트와 [B04 Fixture](https://github.com/Mybread2/pleos-care-log/tree/1e779a6eb2f121064e28cfd9824d5aff24b079a4/mock-fixtures)는 `b06` 브랜치에서 실행할 수 있습니다.
