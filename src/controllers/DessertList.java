package controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import beans.Dessert;
import mappers.IDessertMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import tools.DBTool;

@Controller
public class DessertList {

	@RequestMapping(value = "queryDessert")
	@ResponseBody
	public String queryDessert() {
		String str = "";
		SqlSession session = DBTool.getSession();
		IDessertMapper mapper = session.getMapper(IDessertMapper.class);
		List<Dessert> dessert = new ArrayList<Dessert>();
		try {
			dessert = mapper.queryDessert();
			session.commit();
			str = JSONArray.fromObject(dessert).toString();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return str;
	}
	@RequestMapping(value = "queryNameAndPrice",method=RequestMethod.POST)
	@ResponseBody
	public String queryNameAndPrice(@RequestBody String data){
		String str="";
		int id=0;
		SqlSession session = DBTool.getSession();
		IDessertMapper mapper = session.getMapper(IDessertMapper.class);
		Dessert dessert=new Dessert();
		JSONObject jObj=JSONObject.fromObject(data);
		id= jObj.getInt("id");
		try {
			dessert=mapper.queryNameAndPrice(id);
			session.commit();
			str=JSONObject.fromObject(dessert).toString();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return str;
	}
}
