package com.benno.train.member.service;

import cn.hutool.core.collection.CollUtil;
import com.benno.train.common.exception.BusinessException;
import com.benno.train.common.exception.BusinessExceptionEnum;
import com.benno.train.common.util.SnowUtil;
import com.benno.train.member.domain.Member;
import com.benno.train.member.domain.MemberExample;
import com.benno.train.member.mapper.MemberMapper;
import com.benno.train.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Resource
    MemberMapper memberMapper;

    public int count() {
        return Math.toIntExact(memberMapper.countByExample(null));
    }

    public long register(MemberRegisterReq req) {
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> members = memberMapper.selectByExample(memberExample);
        if (CollUtil.isNotEmpty(members)) {
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }


}
