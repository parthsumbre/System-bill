package com.app.dto;

import java.util.List;

import com.app.Pojo.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommonApiResponse {

	private String responseMessage;
	private Object data;
	
	private boolean isSuccess;

	public CommonApiResponse(String responseMessage, Object data) {
        this.responseMessage = responseMessage;
        this.data = data;
    }

	

}
