package controllers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import beans.Order;
import mappers.IOrderMapper;
import net.sf.json.JSONObject;
import tools.DBTool;

@Controller
public class OrderList {

	@RequestMapping(value = "insertOrder")
	@ResponseBody
	public String insertOrder(@RequestBody String data) {
		String str = "";
		int i = 0;
		JSONObject jObj = JSONObject.fromObject(data);
		String time = jObj.getString("time");
		Double money = jObj.getDouble("money");
		int status = jObj.getInt("status");
		String content = jObj.getString("content");
		String no=jObj.getString("no");
		Order order = new Order(status, money, time, content, no);
		SqlSession session = DBTool.getSession();
		IOrderMapper mapper = session.getMapper(IOrderMapper.class);
		try {
			i = mapper.insertOrder(order);
			session.commit();
			if (i > 0)
				str = "success";
			else
				str = "fail";

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

		return str;
	}
	
	@RequestMapping(value = "deleteOrder")
	@ResponseBody
	public String deleteOrder(@RequestBody String data){
		String str="";
		int i=0;
		JSONObject jObj = JSONObject.fromObject(data);
		String no = jObj.getString("no");
		SqlSession session = DBTool.getSession();
		IOrderMapper mapper = session.getMapper(IOrderMapper.class);
		try {
			i = mapper.deleteOrder(no);
			session.commit();
			if (i > 0)
				str = "success";
			else
				str = "fail";

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		
		return str;
	}
}
