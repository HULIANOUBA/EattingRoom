package controllers;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import beans.Food;
import mappers.IFoodMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tools.DBTool;

@Controller
public class FoodLists {

	@RequestMapping(value = "getFoodLists")
	@ResponseBody
	public String getFoodLists() {
		String str = "";
		SqlSession session = DBTool.getSession();
		IFoodMapper mapper = session.getMapper(IFoodMapper.class);

		try {
			List<Food> food = new ArrayList<Food>();
			food = mapper.queryFood();
			session.commit();
			str = JSONArray.fromObject(food).toString();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return str;
	}

	@RequestMapping(value = "insertFood")
	@ResponseBody
	public String insertFood() {
		int i = 0;
		SqlSession session = DBTool.getSession();
		IFoodMapper mapper = session.getMapper(IFoodMapper.class);
		Food food = new Food("Ã«Ïß", 5.0, 1, "hhhhh");

		try {
			i = mapper.insertFood(food);
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		if (i > 0)
			return "success";
		else
			return "fail";

	}

	@RequestMapping(value = "queryFoodName")
	@ResponseBody
	public String queryFoodName() {
		String str = "";
		SqlSession session = DBTool.getSession();
		IFoodMapper mapper = session.getMapper(IFoodMapper.class);
		try {
			List<String> food = new ArrayList<String>();
			food = mapper.queryFoodName();
			session.commit();
			str = JSONArray.fromObject(food).toString();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return str;
	}

	@RequestMapping(value = "queryCityName")
	@ResponseBody
	public String queryCityIDbyfoodName(@RequestBody String data) {
		String str = "";
		List<String> list = new ArrayList<String>();
		JSONObject jObj = JSONObject.fromObject(data);
		String name = jObj.getString("liContent");
		SqlSession session = DBTool.getSession();
		IFoodMapper mapper = session.getMapper(IFoodMapper.class);
		try {
			list = mapper.queryCityName(name);
			str = JSONArray.fromObject(list).toString();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

		return str;
	}
}
