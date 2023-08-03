package app.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cust {
	private String id;
	private String pwd;
	private String name;
}
