package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO { // DAO는 테이블 당 하나씩

	public int delete(int no) {
		int result = 0;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mysql과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "Ti980130!";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mysql 연결 성공.");

			// 3. SQL
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement가 SQL부품!
			String sql = "delete from book where no = ?";
			// con부품을 이용해서 sql에 있는 것을 SQL부품으로
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			result = ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("책삭제 성공!");
			} else {
				System.out.println("책삭제 실패!");
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int update(BookVO bag) {
		int result = 0;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mysql과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "Ti980130!";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mysql 연결 성공.");

			// 3. SQL
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement가 SQL부품!
			String sql = "update book set content = ? where no = ?";
			// con부품을 이용해서 sql에 있는 것을 SQL부품으로
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getContent());
			ps.setInt(2, bag.getNo());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			result = ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("책수정 성공!");
			} else {
				System.out.println("책수정 실패!");
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int insert(BookVO bag) {
		int result = 0;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mysql과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "Ti980130!";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mysql 연결 성공.");

			// 3. SQL
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement가 SQL부품!
			// String sql = "insert into hr.MEMBER values ('" + id + "', '" + pw + "', '" +
			// name + "', '" + tel + "')";
			String sql = "insert into book values (?, ?, ?, ?, ?)";
			// con부품을 이용해서 sql에 있는 것을 SQL부품으로
			// R빼고, 인덱스는 0부터 시작!
			// 유일하게 db는 인덱스가 1부터 시작!!
			PreparedStatement ps = con.prepareStatement(sql);

			// 2.가방에서 값들을 하나씩 꺼내쓰세요.
			ps.setInt(1, bag.getNo());
			ps.setString(2, bag.getTitle());
			ps.setString(3, bag.getContent());
			ps.setString(4, bag.getImg());
			ps.setString(5, bag.getWriter());
			// ==> insert into hr.MEMBER values ('','','','');
			// System.out.println(sql);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			result = ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("책등록 성공!");
			} else {
				System.out.println("책등록 실패!");
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			// insert가 제대로 안된 경우, 위험한 상황이라고 판단하여
			// catch가 실행
			// 실행된 Row수가 없으므로 Result에 0을 넣어주자!
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	public BookVO one(int no) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		// 기본형 정수/실수/문자/논리만 값으로 초기화
		// 나머지 데이터형(참조형) 주소가! 들어가 있음.
		// 참조형 변수를 초기화할 때는 null(주소가 없다라는 의미)
		BookVO bag = null;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mysql과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "Ti980130!";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mysql 연결 성공.");

			// 3. SQL
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement가 SQL부품!
			String sql = "select * from book where no = ?";
			// con부품을 이용해서 sql에 있는 것을 SQL부품으로
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			// result = ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");

			if (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				bag = new BookVO();
				bag.setNo(rs.getInt("no"));
				bag.setTitle(rs.getString("title"));
				bag.setContent(rs.getString("content"));
				bag.setImg(rs.getString("img"));
				bag.setWriter(rs.getString("writer"));
			} else {
				System.out.println("검색결과 없음");
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bag;
	}

	public ArrayList<BookVO> many(String title) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		// 가방들을 넣어줄 큰 컨테이너 역할을 하는 부품이 필요!
		// ArrayList<MemberVO> => MemverVO만 들어간 arrayList라는 의미
		ArrayList<BookVO> list = new ArrayList<>();

		BookVO bag = null;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mysql과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "Ti980130!";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mysql 연결 성공.");

			// 3. SQL
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement가 SQL부품!
			String sql = "select no, title, writer, img from book where title like ?";
			// con부품을 이용해서 sql에 있는 것을 SQL부품으로
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + title + "%");
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			// result = ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");

			while (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				bag = new BookVO();
				bag.setNo(rs.getInt("no"));
				bag.setTitle(rs.getString("title"));
				bag.setWriter(rs.getString("writer"));
				bag.setImg(rs.getString("img"));
				// 4. list에 bag을 추가해주자.
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<BookVO> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		// 가방들을 넣어줄 큰 컨테이너 역할을 하는 부품이 필요!
		// ArrayList<MemberVO> => MemverVO만 들어간 arrayList라는 의미
		ArrayList<BookVO> list = new ArrayList<>();

		BookVO bag = null;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. mysql과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "Ti980130!";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. mysql 연결 성공.");

			// 3. SQL
			// 자바는 부품조립식이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식하려면 그 부품으로 만들어주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement가 SQL부품!
			String sql = "select no, title, writer, img from book";
			// con부품을 이용해서 sql에 있는 것을 SQL부품으로
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기");

			// result = ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");

			while (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				bag = new BookVO();
				bag.setNo(rs.getInt("no"));
				bag.setTitle(rs.getString("title"));
				bag.setWriter(rs.getString("writer"));
				bag.setImg(rs.getString("img"));
				// 4. list에 bag을 추가해주자.
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
