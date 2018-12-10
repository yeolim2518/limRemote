# tiles.xml 태그 알아보기
### 첫번째 이미지의 name의 값과 2번째 이미지의 return값이 동일하다면 매핑이 됩니다.

![image](https://user-images.githubusercontent.com/42727909/49492322-250c9100-f89b-11e8-85e6-0b1d0b3bcb91.png)
![image](https://user-images.githubusercontent.com/42727909/49492395-6a30c300-f89b-11e8-8e59-1f9bf36b676f.png)

### 1. 매핍은 *를 사용하여 동적으로 매핍을 시킬 수 있습니다.
첫번째 처럼 값을 절대값으로 사용 할 수도 있지만 그렇게 되면 한 페이지당 하나의 definition를 만들어야 하는 불편함이 존재 하기 때문에 이는 타일즈를 사용하는 의미가 퇴색될 수 있습니다. 

그래서 동일한 레이아웃으로 구성되는 모든 페이지를 하나의 definition로 매핍시키기 위해서는 ` * ` 를 사용 합니다. *로 넘어온 값을 attribute에서 사용 할 수 있는데 적용 할 때는 ` {1}, {2} .. {n} `의 순서로 사용 할 수 있습니다.
아래의 그림에서는 {1}에는 home이 {2}에는 test 들어옵니다. *를 2개만 사용 했기 때문에 {}는 2까지만 사용할수 있습니다.

![image](https://user-images.githubusercontent.com/42727909/49559958-f1da0880-f953-11e8-8a47-ca68053ecac7.png)


### 2. 상속받기
기존에 정의 된 definition와 중복 된 내용이 존재할 때는 extends속성을 이용하여 상속을 받을수 있습니다. extends속성의 값은 상속받을 definition의 name을 작성하면 됩니다(이때 **name의 값에 *가 들어가도 정상적으로 상속 받을 수 있습니다.**).

- extends를 사용 할 때는 새롭게 레이아웃을 적용할 **template과 함께 사용** 할 수 있습니다.
- attribute를 추가해서 사용도 가능합니다.

![image](https://user-images.githubusercontent.com/42727909/49492994-bbda4d00-f89d-11e8-9991-e19e8cdbd330.png)

#### [README로 돌아가기](../README.md)
