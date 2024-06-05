package com.stude.globalexceptionhandle;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ExceptionMesseage {

	private Date timeStamp;
	private String message;
	private String details;

}
