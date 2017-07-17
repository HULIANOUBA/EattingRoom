package beans;

public class Order {
	private Integer id;
	private Integer status;
	private Double money;
	private String time;
	private String content;
	private String no;

	public Order(Integer status, Double money, String time, String content, String no) {
		super();
		this.status = status;
		this.money = money;
		this.time = time;
		this.content = content;
		this.no = no;
	}

	public Order(Integer id, Integer status, Double money, String time, String content, String no) {
		super();
		this.id = id;
		this.status = status;
		this.money = money;
		this.time = time;
		this.content = content;
		this.no = no;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", money=" + money + ", time=" + time + ", content=" + content
				+ ", no=" + no + "]";
	}

}
