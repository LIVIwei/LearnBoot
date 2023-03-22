package com.example.justtest.entity;

import com.example.justtest.domain.rcv.RcvOrder;
import lombok.Data;

/**
 *  订单扩展对象
 */
@Data
public class RcvOrderCustom extends RcvOrder {

    private static final String DEFAULT_REFUND_STATUS = "0";

    private String refundStatus = DEFAULT_REFUND_STATUS;

}
