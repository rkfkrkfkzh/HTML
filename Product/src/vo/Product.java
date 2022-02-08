package vo;

public class Product {

	private int p_id;
	private String p_name;
	private int num;
	private String co;
	private int price;
	public Product(int p_id, String p_name, int num, String co, int price) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.num = num;
		this.co = co;
		this.price = price;
	}
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCo() {
		return co;
	}
	public void setCo(String co) {
		this.co = co;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", num=" + num + ", co=" + co + ", price=" + price
				+ "]";
	}
	
	




}
