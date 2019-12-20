package kid1999.upload.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author kid1999
 * @title: Remark
 * @date 2019/12/20 21:56
 */
@Data
public class Remark {
	@TableId(type = IdType.AUTO)    // 自增
	private int id;
	private String name;
	private String remark;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date date;
}
