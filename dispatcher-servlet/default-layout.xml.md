# default-layout.xml 
```html
<?xml version="1.0" encoding="utf-8" ?>
<!DOCTYPE tiles-definitions PUBLIC
       "-//Apache Software Foundation//DTD Tiles Configuration 2.1//EN"
       "http://tiles.apache.org/dtds/tiles-config_2_1.dtd">
 
<tiles-definitions>

	<!-- 공통 -->
	<definition name="*/*.cmmn-tiles" template="/WEB-INF/views/cmmn/default-layouts.jsp">
	  	<put-attribute name="header"    	value="/WEB-INF/views/cmmn/default-header.jsp" />
	  	<put-attribute name="content"		value="/WEB-INF/views/{1}/{2}.jsp"/>
	</definition>
</tiles-definitions>
```
#### [타일즈로 돌아가기](타일즈_tiles.md)
