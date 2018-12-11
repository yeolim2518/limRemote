# 다운로드를 처리할 class

```java
@Component
public class FileDownView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		File file = (File) model.get("file");		// 컨트롤러에서 넘긴 File
		
        // 화면에 파일을 넘겨주기 위한 설정들
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + 
                java.net.URLEncoder.encode(file.getName(), "utf-8") + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		OutputStream out = response.getOutputStream();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(file);
			
			FileCopyUtils.copy(fis, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if (fis != null) {
				
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			out.close();
		}
	}

}
```

#### [README로 돌아가기](../README.md)