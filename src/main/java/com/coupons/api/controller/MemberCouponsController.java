package com.coupons.api.controller;

import com.coupons.api.dto.Coupons;
import com.coupons.api.service.CouponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@RequestMapping("/member-coupons")
public class MemberCouponsController {

    private final CouponService couponService;

    public MemberCouponsController(CouponService couponService) {
        this.couponService = couponService;
    }

    @Operation(responses = {
            @ApiResponse(responseCode = "200",
                    description = "Returns a list of valid coupons",
                    content = {@Content(mediaType = APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Coupons.class))})
    })
    @GetMapping("/{memberId}")
    public Coupons getAllValidMemberCoupons(
            @Parameter(in = ParameterIn.PATH, name = "memberId", description = "Id of `Member`", example = "12345")
            @PathVariable(value = "memberId") String memberId,
            @RequestParam(value = "latitude", required = false) String latitude,
            @RequestParam(value = "longitude", required = false) String longitude) {

        if (latitude != null && longitude != null) {

            return couponService.getNearByCoupons(memberId, Double.parseDouble(latitude), Double.parseDouble(longitude));
        }

        return couponService.getCoupons(memberId);
    }
}
