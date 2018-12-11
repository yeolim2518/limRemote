# dispatcher-servlet.xml에 bean 추가하기

### 아래의 코드를 복사 후 적당한 곳에 붙여넣기
```
<beans:bean id="multipartResolver"  class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <!-- 최대업로드 가능한 바이트크기 -->
        <beans:property name="maxUploadSize" value="52428800" />
        <!-- defaultEncoding -->
        <beans:property name="defaultEncoding" value="utf-8" />
</beans:bean>
```
#### [setting.xml로 돌아가기](setting.md)