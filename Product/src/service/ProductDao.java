package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Product;

public class ProductDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void con() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ����̹� �ε�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@db202110262237_high?TNS_ADMIN=/Users/imhyojin/Wallet_DB202110262237", "ADMIN", "Dkfdktek36270113"); // connection��ü����
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void discon() { // close�޼��� insert,update�� ����ϸ� ȣ��
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void insert(Product p) {
		con();
	
		String sql = "insert into product values(?,?,?,?,?)";
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getP_id());
			pstmt.setString(2, p.getP_name());
			pstmt.setInt(3, p.getNum());
			pstmt.setString(4, p.getCo());
			pstmt.setInt(5, p.getPrice());
			pstmt.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
		
		
		}


	public ArrayList selectAll() {
		// TODO Auto-generated method stub
		con();
		ArrayList<Product> m = new ArrayList<Product>();
		// MemberVO table�� �ִ� id �÷��� �ż����Ķ���� ���� ������ �� �˻�
		String sql = "select * from Product";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // Query����
			while (rs.next()) {
				m.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getInt(5)));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		discon();
		return m;
	}


	public Product selectProduct(int p_id) {
		// TODO Auto-generated method stub
		con();
		Product m = null;
		// MemberVO table�� �ִ� id �÷��� �ż����Ķ���� ���� ������ �� �˻�
		String sql = "select * from product where p_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,p_id);
			rs = pstmt.executeQuery(); // Query����
			if (rs.next()) {
				m = new Product(rs.getInt(1), rs.getString(2),
						rs.getInt(3), rs.getString(4),rs.getInt(5));
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		discon();
		return m;

	}

	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		System.out.println(p);
		con();
		// PreparedStatement ���� ���� ���ϰ� ���� ���ؼ�(?,?,?,?,?)
		String sql = "update product set  name=?, num=?,  co=?, price=?  where p_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, p.getP_name());
			pstmt.setInt(2, p.getNum());
			pstmt.setString(3, p.getCo());
			pstmt.setInt(4, p.getPrice());
			pstmt.setInt(5, p.getP_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	}

	public void delete(int p_id) {
		// TODO Auto-generated method stub
		con();
		// PreparedStatement ���� ���� ���ϰ� ���� ���ؼ�(?,?,?,?,?)
		String sql = "delete product where p_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	}


}
