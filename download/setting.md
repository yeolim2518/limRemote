# 파일 다운로드를 하기 위한 기본 셋팅

기본 셋팅은 dispatcher-servlet.xml에서 추가합니다.

## 1. 파일다운을 하기

기존에 사용하던 ViewResolver는 jsp를 view로 사용 하던 것이고, 파일다운로드를 할 때는 jsp가 아닌 class를 뷰로 사용하기 위해서 추가적인 ViewResolver를 등록합니다. ViewResolver가 2개 이상인 경우 우선순위를 두기 위해서 order속성을 추가합니다. 

order는 0과 가까울수록 우선순위가 높고 return 값이 null인 경우 다음 우선순위의 ViewResolver가 실행되는 구조입니다.

```html
<beans:bean id="fileViewResolver" class="org.springframework.web.servlet.view.BeanNameViewResolver">
    <beans:property name="order" value="0"/>
</beans:bean>
```

#### [README로 돌아가기](../README.md)