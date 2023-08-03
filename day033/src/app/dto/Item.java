package app.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
	private int id;
	private String name;
	private long price;
	private Date regDate;
}
