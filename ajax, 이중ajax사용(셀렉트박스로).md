``` java
package egovframework.example.selectBox.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.tools.generic.LoopTool.Equals;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.cmmn.JsonUtil;
import egovframework.example.selectBox.service.SelectBoxService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class SelectBoxController {
	
	@Resource
	private SelectBoxService selectBoxService;
	
	@ModelAttribute("parentList")
	public List<EgovMap> parentList() throws Exception {
		return selectBoxService.selectParentBoxList();
	} 

	@RequestMapping(value = "/selectBox.do")
	public String selectBoxMain(ModelMap model) throws Exception {
		
		// List<EgovMap> parentList = selectBoxService.selectParentBoxList();
		// model.addAttribute("parentList", parentList);
		// System.out.println(parentList);
		
		return "selectBox/selectBox.tiles";
	}
	
	@RequestMapping(value = "/childSelectBox.do")
	public void childSelectBoxMain(@RequestParam Map map, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// map으로 받아서 mvc하기~!
		System.out.println("map :" + map);  // map :{param=B00002}
		
		List<EgovMap> childList = selectBoxService.selectChildBoxList(map);
		
		for (int i = 0; i < childList.size(); i++) {
			System.out.println("**childList " + i + " 번째 : " + childList.get(i));
		}
			/*	**childList 0 번째 : {prdCd=P00002, prdNm=별점퍼}
				**childList 1 번째 : {prdCd=P00003, prdNm=별점퍼2}
				**childList 2 번째 : {prdCd=P00004, prdNm=자전거티}*/
		
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("result", 	"SUCCESS");
		resultMap.put("childList", 	childList);
		
		response.setCharacterEncoding("utf-8");
		
		// PrintWriter out = response.getWriter();
		// out.write(JsonUtil.HashMapToJson(resultMap));  =>두줄을 한줄로~~
		// Json타입의 문자열로 바꿔서 화면으로 보냄:write()메서드는 문자열만 사용가능
		response.getWriter().write(JsonUtil.HashMapToJson(resultMap)); 
		
		System.out.println("resultMap : " + resultMap);
		/*resultMap : {result=SUCCESS, 
					childList=[{prdCd=P00002, prdNm=별점퍼}, 
					           {prdCd=P00003, prdNm=별점퍼2}, 
					           {prdCd=P00004, prdNm=자전거티}]}*/
		
	}
}
```
