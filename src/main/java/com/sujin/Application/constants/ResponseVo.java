package com.sujin.Application.constants;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseVo {
    private String code = ResponseCodes.ERROR.getCode();
    private String message = ResponseCodes.ERROR.getMessage();
    private Object data;

    public ResponseVo successData(Object data) {
        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode(ResponseCodes.SUCCESS.getCode());
        responseVo.setMessage(ResponseCodes.SUCCESS.getMessage());
        responseVo.setData(data);
        return responseVo;
    }
}
