# 화면에 출력하기

1. mapper.xml를 통해서 데이터를 가져오는 건 비슷
```
<insert id="upload" parameterType="com.spring.board.service.BoardVO">
    insert into posts(posts_num, posts_user_id, posts_time, posts_contents)
    values (POSTS_NUM_SEQ.nextval, #{postsUserId}, sysdate, #{postsContents})
</insert>
```

2. BLOB를 화면에 출력하면 B@..라는 이상한 글자만 출력 되므로 다른 방식을 차용
    1. 먼저 img에는 파일경로가 아닌 컨트롤러 경로 하나 더 생성(해당 이미지와 관련된 정보를 넘겨주기)
```
<img src="화면을 출력하기 위한 맵핑">
```
    1. 화면에서는 해당 번호를 가지고 다시 오라클로부터 BLOB를 받아옴
```
@RequestMapping(value = "imageView/{fileId}")
public ResponseEntity<byte[]> getByteImg(@PathVariable String fileId) throws SQLException {
    Map<String, Object> map = new HashMap<>();
    
    map.put("fileId", fileId);
    
    boardService.selectPostsInfo(map);
    
    BLOB blob = (BLOB) map.get("result"); 
    
    byte[] imageBytes = blob.getBytes(1, (int) blob.length());
    
    final HttpHeaders headers = new HttpHeaders();
    
    headers.setContentType(MediaType.IMAGE_PNG);
    
    return new ResponseEntity<byte[]>(imageBytes, headers, HttpStatus.OK);
}
```

```
<resultMap type="oracle.sql.BLOB" id="blobTest"></resultMap>
	
<select id="selectPostsInfo" parameterType="map" statementType="CALLABLE">
    {
        call POSTS_INFO (
            #{fileId},
            #{result, mode=OUT, jdbcType = BLOB, resultMap = blobTest}  // jdbcType으로 oracle.sql.BLOB을 할 경우 에러가 나면서 가져와지지 않고 resultMap을 쓰면 가능
        )
    }
</select>
```
