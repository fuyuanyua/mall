package com.example.mallmember.feign;

import com.example.common.utils.PageUtils;
import com.example.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description: CouponFeignService
 * 1.@FeignClient("mall-coupon"): 表示这是一个远程调用客户端，mall-coupon是要被远程调用的服务的名称
 * @Author: lhb
 * @Date: 2021/4/1 21:32
 */

@FeignClient("mall-coupon")
public interface CouponFeignService {

    /**
     * 远程调用mall-coupon服务的/mallcoupon/coupon/member/list接口
     * @return
     */
    @RequestMapping("/mallcoupon/coupon/member/list")
    public R listMemberCoupon();
}
