package project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import project.vo.BuyVo;
import project.vo.CustomerBuyVo;

public class TblBuyDao {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL ="jdbc:oracle:thin:@localhost:1521/xe";
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

    // executeUpdate 메소드는 insert, update, delete가 정상 실행되면(반영된 행이 있으면) 1을 리턴
    //                              ㄴ update, delete는 조건에 맞는 행이 없으면 0을 리턴
    public int add(BuyVo vo) {
        int result = 0;
        String sql = "INSERT INTO TBL_BUY (BUY_IDX , CUSTOMID, PCODE, QUANTITY, BUY_DATE) \r\n" + //
                "VALUES (buy_pk_seq.nextval, ?, ?, ?, SYSDATE)";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, vo.getCustomid());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("장바구니 추가 실패 " + e.getMessage());
        }

        return result;
    }

    // 장바구니 모두 구매
    //  ㄴ Batch(배치)는 일괄처리 : 실행할 여러개의 insert, update, delete 등의 데이터 저장 DML을 모아 두었다가 한번에 실행
    //  ㄴ 트랜잭션 : 특정 요구사항에 대한 하나의 기능을 실행할 여러 SQL 명령들로 구성된 작업단위
    //          ㄴ 트랜잭션 commit 모드를 auto에서 수동으로 변경
    //  ㄴ 예시 : cart에 저장된 상품 중 하나라도 참조값이 없는 pcode가 있으면 rollback, 모두 정상이면 commit
    public int addMany(List<BuyVo> cart) { //  여러번의 insert 실행
        int count = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO TBL_BUY (BUY_IDX , CUSTOMID, PCODE, QUANTITY, BUY_DATE) \r\n" + //
                "VALUES (buy_pk_seq.nextval, ?, ?, ?, SYSDATE)";

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            conn.setAutoCommit(false); // 트랜잭션 commit 모드 auto 해제
            for(BuyVo vo : cart) {
                pstmt.setString(1, vo.getCustomid());
                pstmt.setString(2, vo.getPcode());
                pstmt.setInt(3, vo.getQuantity());
                pstmt.addBatch(); // SQL을 메모리에 모아두기
                count++;
            }

            pstmt.executeBatch(); // 모아둔 SQL을 일괄 실행
            conn.commit();
        } catch (SQLException e) { // 예외처리 : 트랜잭션 처리
            try { conn.rollback(); } catch (SQLException e1) {}
            count = -1;
            System.out.println("구매 불가능한 상품이 있습니다.");
            System.out.println("구매 실패 " + e.getMessage());
        } finally { // 자원 해제
            try { // 트랜잭션 처리를 위해 connection을 사용해야 하므로 직접 close했습니다.
                pstmt.close();
                conn.close();
            } catch (SQLException e) {}
        }

        return count;
    }

    public int remove(int buyIdx) {
        int result = 0;
        String sql = "DELETE FROM TBL_BUY tb WHERE buy_idx = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, buyIdx);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // buy_idx가 없는 값이면 오류는 아니고, delete 반영한 행의 개수가 0이 됩니다.
            System.out.println("구매취소 실패 " + e.getMessage());
        }

        return result;
    }

    public int update(int buyIdx, int quantity) {
        int result = 0;
        String sql = "UPDATE TBL_BUY SET QUANTITY = ? WHERE BUY_IDX = ?";

        try (
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setInt(1, quantity);
            pstmt.setInt(2, buyIdx);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            // buy_idx가 없는 값이면 오류는 아니고, update 반영한 행의 개수가 0이 됩니다.
            System.out.println("구매수량 변경 실패 " + e.getMessage());
        }

        return result;
    }
    
    public List<CustomerBuyVo> selectAllBuyList() {
        List<CustomerBuyVo> list = new ArrayList<CustomerBuyVo>();

        String sql = "SELECT BUY_IDX, tb.CUSTOMID, tp.PCODE, PNAME, PRICE, QUANTITY, BUY_DATE \r\n" + //
                "FROM TBL_BUY tb \r\n" + //
                "JOIN TBL_PRODUCT tp \r\n" + //
                "ON tb.PCODE = tp.PCODE \r\n" + //
                "ORDER BY BUY_DATE DESC";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CustomerBuyVo(
                    rs.getInt("buy_idx"),
                    rs.getString("customid"),
                    rs.getString("pcode"),
                    rs.getString("pname"),
                    rs.getInt("price"),
                    rs.getInt("quantity"),
                    rs.getTimestamp("buy_date")
                ));
            }
        } catch (SQLException e) {
            System.out.println("내 구매정보 조회 실패 : " + e.getMessage());
        }

        return list;
    }

    // MyPage 기능 메소드
    public List<CustomerBuyVo> selectCustomerBuyList(String customId) {
        List<CustomerBuyVo> list = new ArrayList<CustomerBuyVo>();

        String sql = "SELECT BUY_IDX, tp.PCODE, PNAME, PRICE, QUANTITY, BUY_DATE \r\n" + //
                "FROM TBL_BUY tb \r\n" + //
                "JOIN TBL_PRODUCT tp \r\n" + //
                "ON tb.PCODE = tp.PCODE \r\n" + //
                "WHERE tb.CUSTOMID = ? \r\n" + //
                "ORDER BY BUY_DATE DESC";

        try (
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, customId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new CustomerBuyVo(
                    rs.getInt("buy_idx"),
                    rs.getString("pcode"),
                    rs.getString("pname"),
                    rs.getInt("price"),
                    rs.getInt("quantity"),
                    rs.getTimestamp("buy_date")
                ));
            }
        } catch (SQLException e) {
            System.out.println("내 구매정보 조회 실패 : " + e.getMessage());
        }

        return list;
    }

    public int money_of_dayByCustomer(String customerid, String buyDate) {  
        String sql = "{ call money_of_day(?,?,?) }";
        int result = 0;

        try (
            Connection connection = getConnection();
            CallableStatement cstmt = connection.prepareCall(sql);
        ) {
            // 프로시저 IN 매개변수값 전달
            cstmt.setString(1, customerid);
            cstmt.setString(2, buyDate);

            // 프로시저 OUT 매개변수 타입 설정
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate();

            result = cstmt.getInt(3);
        } catch (SQLException e) {
            System.out.println("money of day 프로시저 실행 오류 : " + e.getMessage());
        }

        return result;
    }
}
