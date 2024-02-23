package day4.mybatis.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

// 웹에서는 vo 단어 대신 dto를 많이 씁니다.
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerBuyDto {
	private int buy_idx;
	private String customid;
    private String pcode;
    private String pname;
    private int price;
    private int quantity;
    private Date buy_date;

    public CustomerBuyDto(String customid, String pcode, int quantity) {
        this.customid = customid;
        this.pcode = pcode;
        this.quantity = quantity;
    }

    public CustomerBuyDto(String customid, String pcode, int quantity, Date buy_date) {
        this.customid = customid;
        this.pcode = pcode;
        this.quantity = quantity;
        this.buy_date = buy_date;
    }
    
    public CustomerBuyDto(int buy_idx, String pcode, String pname, int price, int quantity, Date buy_date) {
    	this.buy_idx = buy_idx;
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
        this.quantity = quantity;
        this.buy_date = buy_date;
    }
}