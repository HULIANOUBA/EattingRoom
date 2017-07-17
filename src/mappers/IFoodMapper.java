package mappers;

import java.util.List;

import beans.Food;

public interface IFoodMapper {

	public int insertFood(Food food) throws Exception;

	public List<String> queryFoodName() throws Exception;

	public List<Food> queryFood() throws Exception;

	public List<String> queryCityName(String str) throws Exception;
}
