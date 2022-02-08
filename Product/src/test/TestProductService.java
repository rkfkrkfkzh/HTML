package test;

import java.util.Scanner;

import service.ProductDao;
import vo.Product;

public class TestProductService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int p_id;
		String p_name;
		int num;
		String co;
		int price;

		boolean flag = true;
		int i = 0;

		ProductDao service = new ProductDao();

		while (flag) {

			System.out.println("1.���");
			System.out.println("2.��ü���");
			System.out.println("3.�˻�");
			System.out.println("4.����");
			System.out.println("5.����");
			System.out.println("6.����");
			i = sc.nextInt();

			switch (i) {

			case 1:
				System.out.println("��ǰ��ȣ�� �Է��ϼ��� :");
				p_id = sc.nextInt();
				System.out.println("��ǰ���� �Է��ϼ��� :");
				p_name = sc.next();
				System.out.println("������ �Է��ϼ��� :");
				num = sc.nextInt();
				System.out.println("������ �� �Է��ϼ��� :");
				co = sc.next();
				System.out.println("������ �Է��ϼ��� :");
				price = sc.nextInt();

				service.insert(new Product(p_id, p_name, num, co, price));
				break;

			case 2:
				System.out.println(service.selectAll());

				break;

			case 3:
				System.out.println("��ǰ��ȣ�� �Է��ϼ��� :");
				p_id = sc.nextInt();
				Product p = service.selectProduct(p_id);

				System.out.println(p);
				break;

			case 4:
				System.out.println("��ǰ��ȣ�� �Է��ϼ��� :");
				p_id = sc.nextInt();
				System.out.println("������ ��ǰ���� �Է��ϼ��� :");
				p_name = sc.next();
				System.out.println("������ ������ �Է��ϼ��� :");
				num = sc.nextInt();
				System.out.println("������ ������ �� �Է��ϼ��� :");
				co = sc.next();
				System.out.println("������ ������ �Է��ϼ��� :");
				price = sc.nextInt();

				Product m2 = new Product(p_id, p_name, num, co, price);
				service.updateProduct(m2);
				break;

			case 5:

				System.out.println("������ id�� �Է��ϼ��� : ");
				p_id = sc.nextInt();
				service.delete(p_id);
				break;

			case 6:
				flag = false;
				break;

			default:
				System.out.println("�߸� �Է��߾�� �ٽ� �Է��ϼ��� ");

			}

		}

	}
}
