package project.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class CustomerBuyVo {
    private int buy_idx;
    private String customId;
    private String pcode;
    private String pname;
    private int price;
    private int quantity;
    private Timestamp buy_date;
    
    public CustomerBuyVo(
    	int buy_idx,
    	String pcode,
    	String pname,
    	int price,
    	int quantity,
    	Timestamp buy_date
    ) {
    	this.buy_idx = buy_idx;
    	this.pcode = pcode;
    	this.pname = pname;
    	this.quantity = quantity;
    	this.buy_date = buy_date;
    }
}
