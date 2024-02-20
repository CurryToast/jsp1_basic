package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.CustomerVo;

public class TblCustomerDao {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL ="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "c##iidev";
    private static final String PASSWORD = "123456";

    private Connection getConnection() throws SQLException {
    	try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 회원 가입
    public void join(CustomerVo vo) {
        String sql = "Insert into tbl_custom (custom_id, name, email, age, reg_date) values (?,?,?,?,sysdate)";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) { // Auto Close
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // customid와 pcode는 참조 테이블의 존재하는 값으로 해야합니다. => 무결성
            System.out.println("회원가입 실패 " + e.getMessage());
        }
    }

    // 회원 정보 수정
    public void modify(CustomerVo vo) {
        String sql = "UPDATE TBL_CUSTOM SET EMAIL = ?, age = ? WHERE CUSTOM_ID = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, vo.getEmail());
            pstmt.setInt(2, vo.getAge());
            pstmt.setString(3, vo.getCustomId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("회원정보 수정 실패 " + e.getMessage());
        }
    }

    // 회원 탈퇴
    public void delete(String id) {
        String sql = "DELETE FROM TBL_CUSTOM WHERE CUSTOM_ID = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("회원 탈퇴 실행 " + e.getMessage());
        }
    }

    // 회원 정보 조회
    // 조회 결과는 0 혹은 1개.
    public CustomerVo getCustomer(String customerId) {
        String sql = "SELECT * FROM TBL_CUSTOM WHERE CUSTOM_ID = ?";
        CustomerVo vo = null;

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, customerId);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) { // 첫번째 행 조회 결과가 있으면 true
                vo = new CustomerVo(
                    result.getString("CUSTOM_ID"),
                    result.getString("NAME"),
                    result.getString("EMAIL"),
                    result.getInt("AGE"),
                    result.getDate("REG_DATE")
                );
            }
        } catch (SQLException e) {
            System.out.println("회원정보 조회 실패 : " + e.getMessage());
        }

        return vo;
    }
    
    public List<CustomerVo> getCustomerBy(String name, int age) {
        String sql = "SELECT * FROM TBL_CUSTOM WHERE name = ? and age = ?";
        List<CustomerVo> list = new ArrayList<>();

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            ResultSet result = pstmt.executeQuery();

            if (result.next()) { // 첫번째 행 조회 결과가 있으면 true
            	list.add(new CustomerVo(
                    result.getString("CUSTOM_ID"),
                    result.getString("NAME"),
                    result.getString("EMAIL"),
                    result.getInt("AGE"),
                    result.getDate("REG_DATE")
                ));
            }
        } catch (SQLException e) {
            System.out.println("회원정보 조회 실패 : " + e.getMessage());
        }

        return list;
    }

    // 관리자를 위한 기능 : 모든 회원정보 조회
    public List<CustomerVo> allCustomers() {
        String sql = "SELECT * FROM TBL_CUSTOM";
        List<CustomerVo> vo = new ArrayList<CustomerVo>();

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            ResultSet result = pstmt.executeQuery();
            while (result.next()) {
                vo.add(new CustomerVo(
                    result.getString("CUSTOM_ID"),
                    result.getString("NAME"),
                    result.getString("EMAIL"),
                    result.getInt("AGE"),
                    result.getDate("REG_DATE")
                ));
            }
        } catch (SQLException e) {
            System.out.println("모든 회원정보 조회 실패 : " + e.getMessage());
        }

        return vo;
    }
}
