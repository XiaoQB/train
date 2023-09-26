package com.benno.train.member.controller;

import com.benno.train.common.resp.CommonResp;
import com.benno.train.member.req.MemberRegisterReq;
import com.benno.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    MemberService memberService;

    @GetMapping("/count")
    public CommonResp<Integer> count() {
        int count = memberService.count();
        CommonResp<Integer> resp = new CommonResp<>();
        resp.setContent(count);
        return resp;
    }

    @PostMapping("/register")
    public CommonResp<Long> register(MemberRegisterReq req) {
        long register = memberService.register(req);
        return new CommonResp<>(register);
    }
}
