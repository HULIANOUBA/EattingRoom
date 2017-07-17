package mappers;

import beans.Order;

public interface IOrderMapper {
   public int insertOrder(Order order)throws Exception;
   public int deleteOrder(String no)throws Exception;
}
