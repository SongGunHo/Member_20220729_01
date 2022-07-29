package com.its.member_20220729_01;
import static org.assertj.core.api.Assertions.*;
import com.its.member_20220729_01.dto.MemberDTO;
import com.its.member_20220729_01.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class test {
    @Autowired
    private MemberService memberService;
    MemberDTO newMember(int i){
        MemberDTO member=
                new MemberDTO("memberEmail"+i,"memberPassword"+i,"memberName"+i);
        return member;
    }
    @Test
    @Transactional
    @Rollback(value = true)
    @DisplayName("회원가입테스트")
    public void memberSaveTest(){
         Long save = memberService.save(newMember(1));
         MemberDTO byId = memberService.findById(save);
        assertThat(newMember(1).getMemberEmail()).isEqualTo(byId.getMemberEmail());
    }
}
