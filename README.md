# java-racingcar-precourse

## 구현할 기능 목록
1. 입력값 받기 및 검증
- 자동차 이름 문자열 입력
  - 쉼표를 기준으로 구분
  - 5자 이하
- 사용자가 몇 번의 이동을 할 것인지 입력
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생

2. 이동 규칙 적용
- 차수별 각 자동차의 0~9 사이 무작위 값을 추출
- 무작위 값이 4이 이상일 경우 전진

3. 우승자 판정 및 출력
- 완료한 후 우승한 자동차 이름 출력
  - 여러 명일 경우 쉼표를 이용하여 구분

## 프로그램 실행 흐름(MVC 구조)
Application  
↓  
RacingController  
↓  
View(InputString)
↓  
Domain(Car, RacingGame, RandomNum)
↓  
View(OutputView)

## 디렉토리 구조
calculator  
┣ controller  
┃ ┗ RacingController.java  
┣ domain 
┃ ┣ Car.java
┃ ┣ RacingGame.java
┃ ┗ RandomNum.java
┣ view
┃ ┣ InputView.java
┃ ┗ OutputView.java  
┗  Application.java