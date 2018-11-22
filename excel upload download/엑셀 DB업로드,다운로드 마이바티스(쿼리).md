``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="egovframework.example.excel.service.impl.ExcelMapper">

	<insert id="insertExcelList" parameterType="map">
		<selectKey keyProperty="no" order="BEFORE" resultType="int">
		SELECT max(NO) + 1 no
		  FROM EMPLOYEE
		</selectKey>
		INSERT INTO EMPLOYEE
			 (NO, <!-- no가 엑셀에 없어서  open="(" 속성대신 수동으로 넣어줌. -->
			 <foreach collection="thCol" item="item" close=")" separator=",">
                            ${item}		<!-- 컬럼명과 테이블명을 할떈 $, 값을 넣어줄떈 # -->
                         </foreach>
	    VALUES
	    	 (#{no},
	    	 <foreach collection="tdData" item="item" close=")" separator=",">
	            #{item}		<!-- 컬럼명과 테이블명을 할떈 $, 값을 넣어줄떈 # -->
	         </foreach>   
	</insert>
	
	<!-- db에서 내가 SELECT에 쓴 순서대로 컬럼을 가져올 때는 map중에서 순서대로 저장이 되는 linkedhashmap써야함. 
				클래스 등록이 안되어 있어서 풀 경로로 넣어야함-->
	<select id="downloadDB" resultType="java.util.LinkedHashMap" >
	 SELECT NO,
                KOR_NAME,
                JUMIN_NOF,
	        JUMIN_NOB,
	        SEX,
	        TECH_LEV,
	        JOP_TYPE,
	        DESIRE_DEPT
	   FROM EMPLOYEE
	  WHERE USE_YN = 'Y'
	  ORDER BY NO DESC
	</select>

</mapper>
```
