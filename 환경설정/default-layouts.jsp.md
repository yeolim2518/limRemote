# default-layouts.jsp 작성하기
### tiles.xml에 설정했었던 파일 경로로 default-layouts.jsp 만들기
![image](https://user-images.githubusercontent.com/42727909/49427063-b4576d00-f7e5-11e8-9994-11b3d12dc396.png)

- 상단에 디렉티브 추가
    - `<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>`
- 원하는 레이아웃 위치에 attribute추가
    - `<tiles:insertAttribute name="attribute이름"/>` 형식으로 추가
    - attribute이름은 `default-layout.xml`에서 `put-attribute` 태그의 **name**값

![image](https://user-images.githubusercontent.com/42727909/49427560-f3d28900-f7e6-11e8-8c5f-cb84fcde4df3.png)
![image](https://user-images.githubusercontent.com/42727909/49559224-6bbcc280-f951-11e8-834a-8129294c5097.png)

### 나머지 파일 작성

attribute의 value의 값에 들어가는 파일들을 모두 작성합니다.

![image](https://user-images.githubusercontent.com/42727909/49559526-6613ac80-f952-11e8-9ed1-0854062916f0.png)


#### [README로 돌아가기](../README.md)
