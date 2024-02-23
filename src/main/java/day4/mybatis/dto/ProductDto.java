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
public class ProductDto {
	private String pcode;
    private String category;
    private String pname;
    private int price;
}