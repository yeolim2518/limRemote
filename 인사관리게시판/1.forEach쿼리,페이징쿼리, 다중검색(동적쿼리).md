``` xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="egovframework.example.employee.service.impl.EmployeeMapper">

<select id="selectempList" parameterType="pagingVO" resultType="egovMap">
	SELECT 	F.NO,
			F.KOR_NAME,
			F.JUMIN_NOF,
	        F.JUMIN_NOB,
	        F.SEX,
	        F.TECH_LEV,
	        F.JOP_TYPE,
	        F.DESIRE_DEPT,
	        F.pageNumber
	   FROM (SELECT AA.*,		<!-- ROWNUM :각 row마다 번호를 붙여줘서 우리가 원하는 row들을 가져올수있도록 해줌. 각 테이블마다 자동으로 들어가는 가상컬럼 -->
	        		FLOOR((ROWNUM - 1) / #{rows} + 1) AS pageNumber
	 		   FROM (SELECT A.*
	                   FROM EMPLOYEE A
	                  WHERE USE_YN = 'Y'
	                  <if test="searchCol != null and searchCol != ''">
	                  	 <!-- <${searchCol}>, LIKE로 문자열 찾고, <"%" || #{searchCol} || "%"> 
	                  	                   이 컬럼(searchCol)에서    뒤에 문자열이 있는지 찾아줌  -->
	                  	 	AND ${searchCol} LIKE '%' || #{searchVal} || '%'  <!-- 이름 %술개발% -->
	                  </if>
	                  <if test="searchSex != null and searchSex != ''">
	                  		AND SEX = #{searchSex}
	                  </if>
	                  <if test="searchTechLev != null and searchTechLev != ''">
	                  		AND TECH_LEV = #{searchTechLev}
	                  </if>
	                  ORDER BY NO DESC) AA ) F
	 WHERE pageNumber = #{page}
</select>

<!-- 총 row개수, 총 페이지수 구하는 쿼리  -->
<select id="selectEmpListRowCnt" parameterType="pagingVO" resultType="egovMap">
	SELECT COUNT(*) AS TOTAL_CNT,
		   CEIL(COUNT(*) / #{rows}) AS TOTAL_PAGE
	  FROM EMPLOYEE
	 WHERE USE_YN = 'Y' 
	  <if test="searchCol != null and searchCol != ''">
       	 	AND ${searchCol} LIKE '%' || #{searchVal} || '%'  <!-- 이름 %술개발% -->
      </if>
      <if test="searchSex != null and searchSex != ''">
      		AND SEX = #{searchSex}
      </if>
      <if test="searchTechLev != null and searchTechLev != ''">
      		AND TECH_LEV = #{searchTechLev}
      </if> 
</select>

<insert id="insertEmpInfo" parameterType="map">
	<selectKey keyProperty="no" order="BEFORE" resultType="int">
		SELECT max(NO) + 1 no
		  FROM EMPLOYEE
	</selectKey>
	INSERT INTO EMPLOYEE (NO, KOR_NAME, ENG_NAME, CHN_NAME, JUMIN_NOF,
						JUMIN_NOB, IMAGE, BIRTH_Y, BIRTH_M, BIRTH_D,
						SOL_FLAG, SEX, MARRY_FLAG, WORK_YEAR, PAYMENT_TYPE,
						DESIRE_DEPT, JOP_TYPE, ADDRESS, PHONE_F, PHONE_M,
						PHONE_L, EMAIL, TECH_LEV, LIQUOR, IMAGE_ORI)
	VALUES (#{no}, #{korName}, #{engName}, #{chnName}, #{juminNof},
			#{juminNob}, #{image}, #{birthY}, #{birthM}, #{birthD},
			#{solFlag}, #{sex}, #{marryFlag}, #{workYear}, #{paymentType},
			#{desireDept}, #{jopType}, #{address}, #{phoneF}, #{phoneM},
			#{phoneL}, #{email}, #{techLev}, #{liquor}, #{imageOri})
</insert>

<select id="selectEmpViewInfo" parameterType="int" resultType="egovMap">
	SELECT 	NO, KOR_NAME, ENG_NAME, CHN_NAME, JUMIN_NOF,
			JUMIN_NOB, IMAGE, BIRTH_Y, BIRTH_M, BIRTH_D,
			SOL_FLAG, SEX, MARRY_FLAG, WORK_YEAR, PAYMENT_TYPE,
			DESIRE_DEPT, JOP_TYPE, ADDRESS, PHONE_F, PHONE_M,
			PHONE_L, EMAIL, TECH_LEV, LIQUOR, IMAGE_ORI
	  FROM 	EMPLOYEE
	 WHERE 	NO = #{no}
	   AND 	USE_YN = 'Y'
</select>

<update id="updateEmpInfo" parameterType="map">
   UPDATE EMPLOYEE 
   	  SET KOR_NAME 		= #{korName}, 
   	  	  ENG_NAME 		= #{engName}, 
   	  	  CHN_NAME 		= #{chnName},
   	  	  JUMIN_NOF 	= #{juminNof}, 
   	  	  JUMIN_NOB 	= #{juminNob}, 
   	  	  BIRTH_Y 		= #{birthY}, 
   	  	  BIRTH_M 		= #{birthM}, 
   	  	  BIRTH_D 		= #{birthD}, 
   	  	  SOL_FLAG 		= #{solFlag},
		  SEX 			= #{sex}, 
		  MARRY_FLAG 	= #{marryFlag}, 
		  WORK_YEAR 	= #{workYear}, 
		  PAYMENT_TYPE 	= #{paymentType}, 
		  DESIRE_DEPT 	= #{desireDept}, 
		  JOP_TYPE 		= #{jopType}, 
		  ADDRESS 		= #{address}, 
		  PHONE_F 		= #{phoneF}, 
		  PHONE_M 		= #{phoneM},
		  PHONE_L 		= #{phoneL}, 
		  EMAIL 		= #{email}, 
		  TECH_LEV		= #{techLev}, 
		  LIQUOR 		= #{liquor}
		  <if test="image != null and image != ''">
		  	, IMAGE = #{image} , IMAGE_ORI = #{imageOri}
		  </if>
    WHERE NO = #{no}
</update>


<!-- 
  컨트롤러에서 삭제할 체크박스 번호를 여러개 보냇을때(리스트로 받아서 그걸 맵에 담아서 mvc함)
	collection = 전달받은 인자값  ** collection에는 map에 담겨진 list의 key값을 써준다.
	item   = 전달받은 인자값을 다른이름으로 대체 
	open 해당 구문이 시작할떄 (   . close 해당구문이 끝날떄 )
	separator  한번 이상 반복할때 반복되는 사이에  해당 문을 넣어줌
 -->
<delete id="deleteEmpList" parameterType="map">
    UPDATE EMPLOYEE
       SET USE_YN = 'N'
     WHERE NO in 
         <foreach collection="checkbox" item="item" open="(" close=")" separator=",">
            #{item}
         </foreach>
</delete>

<!-- 화면에서 내가 입력한 주민번호 뒷자리 중복체크 -->
<select id="selectJuminResult" parameterType="int" resultType="int">
	SELECT COUNT(*)
	  FROM EMPLOYEE
	 WHERE JUMIN_NOB = #{_parameter} 
</select>
	
</mapper>
```
