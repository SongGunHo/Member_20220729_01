package com.its.member_20220729_01.service;

import com.its.member_20220729_01.dto.MemberDTO;
import com.its.member_20220729_01.entity.MemberEntity;
import com.its.member_20220729_01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Long save(MemberDTO memberDTO){
       return memberRepository.save(MemberEntity.toSaveEntity(memberDTO)).getId();
    }
    public MemberDTO findById(Long id){
         Optional<MemberEntity> byId =memberRepository.findById(id);
         if(byId.isPresent()){
             MemberEntity memberEntity = byId.get();
              MemberDTO memberDTO = MemberDTO.toMemberDTO(memberEntity);
              return memberDTO;
         }else {
             return null;
         }
    }
}
