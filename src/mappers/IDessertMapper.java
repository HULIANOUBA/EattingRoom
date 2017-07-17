package mappers;

import java.util.List;

import beans.Dessert;

public interface IDessertMapper {

	public List<Dessert> queryDessert()throws Exception;
	public Dessert queryNameAndPrice(int id)throws Exception;
}
