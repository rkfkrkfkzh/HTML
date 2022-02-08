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

			System.out.println("1.등록");
			System.out.println("2.전체출력");
			System.out.println("3.검색");
			System.out.println("4.수정");
			System.out.println("5.삭제");
			System.out.println("6.종료");
			i = sc.nextInt();

			switch (i) {

			case 1:
				System.out.println("제품번호를 입력하세요 :");
				p_id = sc.nextInt();
				System.out.println("제품명을 입력하세요 :");
				p_name = sc.next();
				System.out.println("수량를 입력하세요 :");
				num = sc.nextInt();
				System.out.println("제조사 을 입력하세요 :");
				co = sc.next();
				System.out.println("가격을 입력하세요 :");
				price = sc.nextInt();

				service.insert(new Product(p_id, p_name, num, co, price));
				break;

			case 2:
				System.out.println(service.selectAll());

				break;

			case 3:
				System.out.println("제품번호를 입력하세요 :");
				p_id = sc.nextInt();
				Product p = service.selectProduct(p_id);

				System.out.println(p);
				break;

			case 4:
				System.out.println("제품번호를 입력하세요 :");
				p_id = sc.nextInt();
				System.out.println("수정할 제품명을 입력하세요 :");
				p_name = sc.next();
				System.out.println("수정할 수량를 입력하세요 :");
				num = sc.nextInt();
				System.out.println("수정할 제조사 을 입력하세요 :");
				co = sc.next();
				System.out.println("수정할 가격을 입력하세요 :");
				price = sc.nextInt();

				Product m2 = new Product(p_id, p_name, num, co, price);
				service.updateProduct(m2);
				break;

			case 5:

				System.out.println("삭제할 id를 입력하세요 : ");
				p_id = sc.nextInt();
				service.delete(p_id);
				break;

			case 6:
				flag = false;
				break;

			default:
				System.out.println("잘못 입력했어요 다시 입력하세요 ");

			}

		}

	}
}
