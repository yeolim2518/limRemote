# context.xml 작성하기
### 1. src > main > resources 하위에 아래 그림과 같이 디렉토리를 만듭니다.
![image](https://user-images.githubusercontent.com/42727909/49120858-cc188800-f2f1-11e8-90ce-cc2a66e33256.png)
### 2. src > main > resources > spring > context 하위에 context-*.xml 파일들을 만들게 됩니다.
- context-common.xml파일을 만들고 아래의 코드를 삽입

    [context-common.xml](context-common.xml.md)
- context-datasource.xml파일을 만들고 아래의 코드를 삽입

    [context-datasource.xml](context-datasource.xml.md)
- context-mapper.xml파일을 만들고 아래의 코드를 삽입

    [context-mapper.xml](context-mapper.xml.md)
### 3. src > main > resources > spring > message 하위에 공통 메시지를 활용하기 위한 파일을 만듭니다.
- message-common_en.properties 만들고 아래의 코드를 삽입

    [message-common_en.properties](message-common_en.properties.md)
- message-common_ko.properties 만들고 아래의 코드를 삽입

    [message-common_ko.properties](message-common_ko.properties.md)
- message-common.properties 만들고 아래의 코드를 삽입

    [message-common.properties](message-common.properties.md)
### 4. src > main > resources > spring > sqlmap 하위에 sql-mapper-config.xml 파일을 만듭니다.
[sql-mapper-config.xml](sql-mapper-config.xml.md)


# 기본 소스 파일 다운 받으러 가기
[소스파일](https://github.com/yeolim2518/limRemote/files/2622552/spring.zip)

#### [README로 돌아가기](../README.md)
#### [설정완료후작업](../설정끝나고%20각%20폴더%20복붙.md)
